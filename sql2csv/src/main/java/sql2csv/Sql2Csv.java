package sql2csv;

import org.apache.commons.lang3.SystemUtils;
import sql2csv.cli.CommandLine;
import sql2csv.cli.CommandLine.Help;
import sql2csv.cli.CommandLine.NoArgsProvided;
import sql2csv.cli.CommandLine.SyntaxError;
import sql2csv.util.DB;
import sql2csv.util.DataSourceFactory;
import sql2csv.util.RowFormat;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Sql2Csv {

    private final DB db;
    private final String sql;
    private final Writer writer;
    private String separator;
    private boolean showHeader;
    private final Map<String, Object> parameters;

    public Sql2Csv(DB db, String sql, Writer writer) {
        super();
        this.db = db;
        this.sql = sql;
        this.writer = writer;

        this.separator = ",";
        this.showHeader = false;
        this.parameters = new LinkedHashMap<String, Object>();
    }

    public static void main(String[] args) throws IOException {
        try {
            CommandLine commandLine = CommandLine.parse(args);
            DataSource dataSource = DataSourceFactory.newDataSource(
                    commandLine.getDbDriverClassName(),
                    commandLine.getDbUrl(),
                    commandLine.getDbUsername(),
                    commandLine.getDbPassword()
            );

            Sql2Csv sql2csv = new Sql2Csv(new DB(dataSource), commandLine.getSql(), new PrintWriter(System.out));
            if (commandLine.hasToShowHeader())
                sql2csv.showHeader();
            Map<String, Object> parameters = toMap(System.getProperties());
            sql2csv.withSeparator(commandLine.getFieldSeparator())
                    .withParameters(parameters)
                    .run();
        } catch (NoArgsProvided e) {
            System.err.println(CommandLine.help());
            System.exit(2);
        } catch (SyntaxError e) {
            System.err.println(e.getMessage());
            System.exit(2);
        } catch (Help e) {
            System.out.print(CommandLine.help());
            System.exit(0);
        }
    }

    private static Map<String, Object> toMap(Properties properties) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<String> propertyNames = new LinkedList<String>(properties.stringPropertyNames());
        Collections.sort(propertyNames);
        for (String property : propertyNames) {
            String value = properties.getProperty(property);
            //System.err.println(property + " = " + value);
            map.put(property, value);
        }
        return map;
    }

    private Sql2Csv withParameters(Map<String, Object> parameters) {
        this.parameters.putAll(parameters);
        return this;
    }

    public Sql2Csv withParameter(String parameter, Object value) {
        this.parameters.put(parameter, value);
        return this;
    }

    public Sql2Csv withSeparator(String separator) {
        this.separator = separator;
        return this;
    }

    public Sql2Csv showHeader() {
        this.showHeader = true;
        return this;
    }

    public void run() throws IOException {
        db.query(
                sql,
                parameters,
                new Print(new RowFormat(separator), writer, showHeader)
        );
        writer.flush();
    }

    private static class Print implements DB.RowListener {

        private final RowFormat rowFormat;
        private final Writer writer;
        private final boolean showHeader;

        private boolean firstRecord;

        public Print(RowFormat rowFormat, Writer writer, boolean showHeader) {
            super();
            this.rowFormat = rowFormat;
            this.writer = writer;
            this.showHeader = showHeader;

            this.firstRecord = true;
        }

        @Override
        public void onRow(Map<String, Object> row) {
            if (showHeader) {
                if (firstRecord) {
                    print(row.keySet());
                    firstRecord = false;
                }
            }

            print(row.values());
        }

        private void print(Collection<?> values) {
            try {
                String row = rowFormat.format(values);
                writer.write(row);
                writer.write(RowFormat.LINE_SEPARATOR);
            } catch (IOException e) {
                throw new RuntimeException("unexpected error", e);
            }
        }

    }

}
