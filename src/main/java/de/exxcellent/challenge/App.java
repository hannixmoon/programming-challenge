package de.exxcellent.challenge;

import de.exxcellent.challenge.calculator.DataCalculator;
import de.exxcellent.challenge.calculator.FootballDataCalculator;
import de.exxcellent.challenge.calculator.WeatherDataCalculator;
import de.exxcellent.challenge.reader.CsvFileReader;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Hanna Blumstein <blumsteinhanna@gmail.com>
 */
public final class App {
    public static final String MISSING_ARGS_STRING = "Please enter valid arguments! Choose " +
            "[--weather] [filepath] or [--football] [filepath].";
    public static final String BASE_FILE_PATH = "src/main/resources/de/exxcellent/challenge/";

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        if (args.length < 2) {
            logger.log(Level.INFO, MISSING_ARGS_STRING);
        } else if (args[0].equals("--weather")) {
            // Task 1: Weather data
            try {
                List<Map<String, String>> weatherDataList = new CsvFileReader().readFile(BASE_FILE_PATH + args[1]);
                DataCalculator weatherDataCalculator = new WeatherDataCalculator();
                Map<String, String> dayWithSmallestTempSpread = weatherDataCalculator.calcDataWithMinSpread(weatherDataList);
                System.out.printf("Day with smallest temperature spread : %s%n",
                        dayWithSmallestTempSpread.get(WeatherDataCalculator.DAY_COLUMN));

            } catch (IllegalArgumentException e) {
                logger.log(Level.SEVERE, "Error while handling weather data");
            }

        } else if (args[0].equals("--football")) {
            // Task 2: Football data
            try {
                List<Map<String, String>> footballDataList = new CsvFileReader().readFile(BASE_FILE_PATH + args[1]);
                DataCalculator footballDataCalculator = new FootballDataCalculator();
                Map<String, String> teamWithSmallestGoalSpread = footballDataCalculator.calcDataWithMinSpread(footballDataList);
                System.out.printf("Team with smallest goal spread       : %s%n",
                        teamWithSmallestGoalSpread.get(FootballDataCalculator.TEAM_COLUMN));

            } catch (IllegalArgumentException e) {
                logger.log(Level.SEVERE, "Error while handling football data");
            }

        } else {
            logger.log(Level.INFO, MISSING_ARGS_STRING);
        }
    }
}
