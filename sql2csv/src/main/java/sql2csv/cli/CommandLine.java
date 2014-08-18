package sql2csv.cli;

import java.io.*;

import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;

@SuppressWarnings("static-access")
public class CommandLine {

	private static final String OPT_HELP                      = "help";
	private static final String OPT_JDBC_DRIVER               = "jdbc-driver";
	private static final String OPT_JDBC_URL                  = "jdbc-url";
	private static final String OPT_USERNAME                  = "username";
	private static final String OPT_PASSWORD                  = "password";
	private static final String OPT_SQL                       = "sql";
    private static final String OPT_SQL_FILE                  = "sql-file";
	private static final String OPT_HEADER                    = "header";
	private static final String OPT_FIELD_SEPARATOR           = "field-separator";

	private static final Options OPTIONS;

	static {
		OPTIONS = new Options();
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_HELP)
			.withDescription("show this help")
			.create());
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_JDBC_DRIVER)
			.withDescription("the JDBC driver")
			.hasArg()
			.withArgName("CLASSNAME")
			.create("D"));
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_JDBC_URL)
			.withDescription("the JDBC url")
			.hasArg()
			.withArgName("URL")
			.create("U"));
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_USERNAME)
			.withDescription("the username")
			.hasArg()
			.withArgName("USERNAME")
			.create("u"));
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_PASSWORD)
			.withDescription("the password")
			.hasArg()
			.withArgName("PASSWORD")
			.create("p"));
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_SQL)
			.withDescription("the SQL to execute")
			.hasArg()
			.withArgName("SQL")
			.create("S"));
        OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_SQL_FILE)
            .withDescription("the path of a file containing the SQL to execute")
            .hasArg()
            .withArgName("PATH")
            .create("P"));
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_HEADER)
			.withDescription("show the header on first row (please use AS statement with double quoted field names in order to define header case. E.g. SELECT x AS \"MyField\" etc...)")
			.create("H"));
		OPTIONS.addOption(OptionBuilder.withLongOpt(OPT_FIELD_SEPARATOR)
			.withDescription("set field separator (default is ',')")
			.hasArg()
			.withArgName("TEXT")
			.create("F"));
	}

    private final String dbDriverClassName;
	private final String dbUrl;
	private final String dbUsername;
	private final String dbPassword;
	private final String sql;
	private final boolean showHeader;
	private final String fieldSeparator;

    public CommandLine(String dbDriverClassName, String dbUrl, String dbUsername, String dbPassword, String sql, boolean showHeader, String fieldSeparator) {
		super();
		this.dbDriverClassName = dbDriverClassName;
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		this.sql = sql;
		this.showHeader = showHeader;
		this.fieldSeparator = fieldSeparator;
	}

    public static CommandLine parse(String[] args) throws CommandLine.NoArgsProvided, CommandLine.SyntaxError, CommandLine.Help {
		try {
			if (args.length == 0)
				throw new CommandLine.NoArgsProvided();

			org.apache.commons.cli.CommandLine cli = new PosixParser().parse(OPTIONS, args);
			if (cli.hasOption(OPT_HELP))
				throw new CommandLine.Help();

			checkRequiredOption(cli, OPT_JDBC_DRIVER);
			checkRequiredOption(cli, OPT_JDBC_URL);
			checkRequiredOption(cli, OPT_USERNAME);
			checkRequiredOption(cli, OPT_PASSWORD);

			boolean showHeader = cli.hasOption(OPT_HEADER);
			String fieldSeparator = ",";
			if (cli.hasOption(OPT_FIELD_SEPARATOR))
				fieldSeparator = cli.getOptionValue(OPT_FIELD_SEPARATOR);
            return new CommandLine(
					cli.getOptionValue(OPT_JDBC_DRIVER),
					cli.getOptionValue(OPT_JDBC_URL),
					cli.getOptionValue(OPT_USERNAME),
					cli.getOptionValue(OPT_PASSWORD),
                    sql(cli),
					showHeader,
					fieldSeparator
				);
		} catch (ParseException e) {
			throw new CommandLine.SyntaxError(e.getMessage());
		}
	}

    private static String sql(org.apache.commons.cli.CommandLine cli) throws SyntaxError {
        String sql = null;
        if (cli.hasOption(OPT_SQL))
            return cli.getOptionValue(OPT_SQL);

        if (!cli.hasOption(OPT_SQL_FILE))
            throw new SyntaxError("one option between --" + OPT_SQL + " and --" + OPT_SQL_FILE + " is required");

        String filepath = cli.getOptionValue(OPT_SQL_FILE);
        try {
            return FileUtils.readFileToString(new File(filepath));
        } catch (IOException e) {
            throw new SyntaxError("Unable to read SQL file '" + filepath + "'");
        }
    }

    public static String help() {
		HelpFormatter formatter = new HelpFormatter();
		StringWriter textContainer = new StringWriter();
		formatter.printHelp(
			new PrintWriter(textContainer), 
			80, // width 
			"java [-Dparameter=value]... -classpath \"<JDBC_DRIVER_JAR>:sql2csv.jar\" sql2csv.Sql2Csv [OPTIONS...]",
			"  where <JDBC_DRIVER_JAR> is a jar containing the JDBC driver to use." + SystemUtils.LINE_SEPARATOR +
            "The software executes specified SQL and format results to standard output as a CSV." + SystemUtils.LINE_SEPARATOR +
            "Binding parameters are supported using System properties (e.g. passing -Dmyvalue=5 you can use that value in the SQL using :myvalue)",
			OPTIONS, 
			2, 2, // padding
			"Exit status:" + SystemUtils.LINE_SEPARATOR +
				"0  : if OK" + SystemUtils.LINE_SEPARATOR +
				"1  : if an error occurs" + SystemUtils.LINE_SEPARATOR +
				"2  : on a syntax error" + SystemUtils.LINE_SEPARATOR +
            "Example:" + SystemUtils.LINE_SEPARATOR +
                "java -Dsearch=n " + SystemUtils.LINE_SEPARATOR +
                "  -classpath \"ojdbc6-11.2.0.3.0.jar:sql2csv.jar\" sql2csv.Sql2Csv" + SystemUtils.LINE_SEPARATOR +
                "  --jdbc-driver \"oracle.jdbc.OracleDriver\" "+ SystemUtils.LINE_SEPARATOR +
                "  --jdbc-url jdbc:oracle:thin:@//myhost:1521/mysid "+ SystemUtils.LINE_SEPARATOR +
                "--username myuser --password mypassword " + SystemUtils.LINE_SEPARATOR +
                "--sql \"SELECT province AS \\\"Province\\\", zone AS \\\"Zone\\\", description AS \\\"Description\\\" FROM province_zone WHERE description LIKE '%' || :search || '%'\""
        );
		return textContainer.toString();
	}

	public String getDbDriverClassName() {
		return dbDriverClassName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public String getSql() {
		return sql;
	}

	public boolean hasToShowHeader() {
		return showHeader;
	}

    public String getFieldSeparator() {
		return fieldSeparator;
	}

	private static void checkRequiredOption(org.apache.commons.cli.CommandLine cli, String longOption) throws SyntaxError {
		if (! cli.hasOption(longOption))
			throw new SyntaxError("option --" + longOption + " is required");
	}
	
	@SuppressWarnings("serial")
	public static class NoArgsProvided extends Exception {
		public NoArgsProvided() {
			super();
		}
	}

	@SuppressWarnings("serial")
	public static class Help extends Exception {
		public Help() {
			super();
		}
	}

	@SuppressWarnings("serial")
	public static class SyntaxError extends Exception {
		public SyntaxError(String message) {
			super(message);
		}
	}

}
