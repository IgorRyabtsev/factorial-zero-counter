import org.apache.commons.cli.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * The main class that validate and process input data and gives the result.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String HELP_INFORMATION = "This tool allows to count zeros at the end " +
            "of the factorial value of a number.";
    private static final String RESULT_INFORMATION = "Factorial result of number %d end with %d zeros.";
    private final int DEFAULT_NUMBER = 1000;
    private long number;

    private Option numberOption;
    private Option helpOption;
    private Options options = new Options();

    public Main() {
        buildOptions();
    }

    public static void main(String[] args) {
        new Main().serve(args);
    }

    /**
     * Serves the arguments and displays the result or necessary
     * information about errors.
     *
     * @param args input arguments
     */
    private void serve(String[] args) {
        String numberValue = null;
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption(helpOption.getOpt())) {
                printHelp(HELP_INFORMATION);
                return;
            }
            if (cmd.hasOption(numberOption.getOpt())) {
                numberValue = cmd.getOptionValue(numberOption.getOpt());
            }
        } catch (ParseException e) {
            printHelp(e.getMessage());
            logger.warn("Not correct initial arguments");
            return;
        }

        try {
            number = validateAndGet(numberValue);
        } catch (Exception e) {
            printHelp(e.getMessage());
            logger.warn("Not correct number value");
            return;
        }

        System.out.println(String.format(RESULT_INFORMATION, number, FactorialEndZerosCounter.calculateZeros(number)));
    }

    /**
     * Validate the input data.
     *
     * @param numberValue input number in string format
     * @return parsed input number value
     * @throws Exception if input number is negative
     */
    private long validateAndGet(String numberValue) throws Exception {
        if (numberValue == null) {
            return DEFAULT_NUMBER;
        }
        long number = Long.valueOf(numberValue);
        if (number < 0) {
            throw new Exception("Number must be positive value");
        }
        return number;
    }

    /**
     * Prints help in console for user about current problem and
     * usage of this tool.
     *
     * @param message of the exception
     */
    private void printHelp(String message) {
        HelpFormatter formatter = new HelpFormatter();
        System.out.println(message);
        formatter.printHelp("factorial-zero-ends-counter [options] [number]", options);
    }

    /**
     * Setup options for CommandLineParser.
     */
    private void buildOptions() {
        numberOption = Option
                .builder("n")
                .longOpt("number")
                .argName("number")
                .hasArg()
                .desc("Given number for calculations. No more than Long.MAX_VALUE. Default value is 1000.")
                .build();
        helpOption = Option
                .builder("h")
                .longOpt("help")
                .desc("Display usage.")
                .build();
        options.addOption(numberOption);
        options.addOption(helpOption);
    }
}
