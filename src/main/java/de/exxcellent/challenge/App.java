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

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        String baseFilePath = "src/main/resources/de/exxcellent/challenge/";
        String weatherFilePath = baseFilePath + "weather.csv";
        String footballFilePath = baseFilePath + "football.csv";

        // Task 1: Weather data
        try {
            List<Map<String, String>> weatherDataList = new CsvFileReader().readFile(weatherFilePath);
            DataCalculator weatherDataCalculator = new WeatherDataCalculator();
            Map<String, String> dayWithSmallestTempSpread = weatherDataCalculator.calcDataWithMinSpread(weatherDataList);
            System.out.printf("Day with smallest temperature spread : %s%n",
                    dayWithSmallestTempSpread.get(WeatherDataCalculator.DAY_COLUMN));

        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error while handling weather data");
        }

        // Task 2: Football data
        try {
            List<Map<String, String>> footballDataList = new CsvFileReader().readFile(footballFilePath);
            DataCalculator footballDataCalculator = new FootballDataCalculator();
            Map<String, String> teamWithSmallestGoalSpread = footballDataCalculator.calcDataWithMinSpread(footballDataList);
            System.out.printf("Team with smallest goal spread       : %s%n",
                    teamWithSmallestGoalSpread.get(FootballDataCalculator.TEAM_COLUMN));

        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error while handling football data");
        }
    }
}
