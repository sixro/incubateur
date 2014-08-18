package csv2xls.cli;

import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

public class CommandLine {

    public static final String OPTION_HELP = "?";
    public static final String OPTION_VERSION = "v";

    private final String applicationLauncher;
    private final String applicationVersion;
    private final String helpHeader;
    private final String helpFooter;

    private Map<Option, Option.Handler> options;
    private Map<Option, org.apache.commons.cli.Option> optionsMap;
    private Option.Handler additionalArgsHandler;

    public CommandLine(String applicationLauncher, String applicationVersion, String helpHeader, String helpFooter) {
        this.applicationLauncher = applicationLauncher;
        this.applicationVersion = applicationVersion;
        this.helpHeader = helpHeader;
        this.helpFooter = helpFooter;

        this.options = new LinkedHashMap<>();
        this.optionsMap = new LinkedHashMap<>();
        this.additionalArgsHandler = null;
    }

    public CommandLine withOption(Option option, Option.Handler handler) {
        this.options.put(option, handler);
        return this;
    }

    public void parse(String... args) {
//        for (Map.Entry<Option, Option.Handler> entry: options.entrySet()) {
//            System.out.println(entry.getKey());
//        }

        try {
            CommandLineParser parser = new PosixParser();
            Options cliOptions = new Options();
            for (Map.Entry<Option, Option.Handler> entry: this.options.entrySet()) {
                Option option = entry.getKey();
                OptionBuilder optionBuilder = OptionBuilder.withDescription(option.description);
                if (option.longOption != null)
                    optionBuilder.withLongOpt(option.longOption);
                if (option.args > 0)
                    optionBuilder.hasArgs(option.args);

                org.apache.commons.cli.Option opt = optionBuilder.create(option.character);
                cliOptions.addOption(opt);
                optionsMap.put(option, opt);
            }

            org.apache.commons.cli.Option version = OptionBuilder.withDescription("Show version")
                    .withLongOpt("version")
                    .create(OPTION_VERSION);
            cliOptions.addOption(version);

            org.apache.commons.cli.Option help = OptionBuilder.withDescription("Show this help")
                    .withLongOpt("help")
                    .create(OPTION_HELP);
            cliOptions.addOption(help);

            org.apache.commons.cli.CommandLine cli = parser.parse(cliOptions, args);
            if (args.length == 0) {
                showHelp(cliOptions, System.err);
                System.exit(2);
            }
            else if (cli.hasOption(OPTION_HELP)) {
                showHelp(cliOptions, System.out);
                System.exit(0);
            }

            if (cli.hasOption(OPTION_VERSION)) {
                System.out.println(applicationLauncher + " " + applicationVersion);
                System.exit(0);
            }

            for (Map.Entry<Option, org.apache.commons.cli.Option> entry : optionsMap.entrySet()) {
                Option option = entry.getKey();
                String longOption = entry.getValue().getLongOpt();
                if (cli.hasOption(longOption)) {
                    if (option.args > 0) {
                        String[] optionArgs = cli.getOptionValues(longOption);
                        Option.Handler handler = options.get(option);
                        handler.onOption(option, optionArgs);
                    }

                } else {
                    if (option.required) {
                        System.err.println("Missing required option -" + option.character + " (--" + option.longOption + ")");
                        System.exit(1);
                    }
                }
            }

            String[] additionalArgs = cli.getArgs();
            if (additionalArgs.length > 0) {
                if (additionalArgsHandler != null)
                    additionalArgsHandler.onOption(null, additionalArgs);
                else {
                    System.err.println("unhandled args " + StringUtils.join(additionalArgs, ", "));
                    System.exit(2);
                }
            }

        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }

    private void showHelp(Options cliOptions, PrintStream printStream) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setOptionComparator(new Comparator<org.apache.commons.cli.Option>() {
            @Override
            public int compare(org.apache.commons.cli.Option o1, org.apache.commons.cli.Option o2) {
                Integer o1idx = indexOf(o1);
                Integer o2idx = indexOf(o2);
                return o1idx.compareTo(o2idx);
            }

            private int indexOf(org.apache.commons.cli.Option o) {
                int pos = 0;
                for (Map.Entry<Option, org.apache.commons.cli.Option> entry : optionsMap.entrySet()) {
                    if (entry.getValue() == o)
                        break;
                    pos++;
                }
                return pos;
            }
        });

        StringWriter textContainer = new StringWriter();
        formatter.printHelp(
                new PrintWriter(textContainer),
                80, // width
                applicationLauncher + " [OPTIONS...]",
                helpHeader,
                cliOptions,
                2, 2, // padding
                helpFooter);
        printStream.println(textContainer.toString());
    }

    public CommandLine onAdditionalArgs(Option.Handler handler) {
        this.additionalArgsHandler = handler;
        return this;
    }

    public static class Option {

        private final char character;
        private final String description;

        private boolean required;
        private String longOption;
        private int args;

        public Option(char character, String description) {
            this.character = character;
            this.description = description;

            this.required = true;
            this.longOption = null;
            this.args = 0;
        }

        public Option required() {
            this.required = true;
            return this;
        }

        public Option notRequired() {
            this.required = false;
            return this;
        }

        public Option longOption(String longOption) {
            this.longOption = longOption;
            return this;
        }

        public Option args(int args) {
            this.args = args;
            return this;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }

        public static interface Handler {

            void onOption(Option option, String[] values);

        }
    }

}
