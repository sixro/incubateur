package sql2csv.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class RowFormat {

    private static final String QUOTE = "\"";
    private static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat(System.getProperty("dateformat", "yyyy-MM-dd'T'HH:mm:ss"));
    public static final String LINE_SEPARATOR = System.getProperty("linesep", "\r\n");

    private final String separator;

    public RowFormat(String separator) {
        this.separator = separator;
    }

    public String format(Collection<?> values) {
        return format(values.toArray(new Object[0]));
    }

	public String format(Object[] values) {
        formatDates(values);
        quoteTexts(values);
        return joinWithSeparator(values);
    }

    private void formatDates(Object[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Date)
                values[i] = ISO_DATE_FORMAT.format((Date) values[i]);
        }
    }

    private void quoteTexts(Object[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof String) {
                String text = (String) values[i];
                if (text.contains(QUOTE) || text.contains(LINE_SEPARATOR) || text.contains(separator)) {
                    text = text.replaceAll(QUOTE, QUOTE + QUOTE);
                    text = new StringBuilder()
                            .append(QUOTE)
                            .append(text)
                            .append(QUOTE)
                            .toString();
                }
                values[i] = text;
            }
        }
    }

    private String joinWithSeparator(Object[] values) {
        return StringUtils.join(values, separator);
    }

}
