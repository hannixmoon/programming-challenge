package de.exxcellent.challenge;

import de.exxcellent.challenge.calculator.FootballDataCalculator;
import de.exxcellent.challenge.calculator.WeatherDataCalculator;
import de.exxcellent.challenge.reader.CsvReader;

import java.util.List;
import java.util.Map;

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
        String baseFilePath = "src/main/resources/de/exxcellent/challenge/";
        String weatherFilePath = baseFilePath + "weather.csv";
        String footballFilePath = baseFilePath + "football.csv";

        List<Map<String, String>> weatherHashmap = CsvReader.readCsvFile(weatherFilePath);
        List<Map<String, String>> footballHashMap = CsvReader.readCsvFile(footballFilePath);

        try {
            // Task 1: Weather data
            var weatherDataCalculator = new WeatherDataCalculator();
            Map<String, String> dayWithSmallestTempSpread = weatherDataCalculator.calcDataWithMinSpread(weatherHashmap);
            System.out.printf("Day with smallest temperature spread : %s%n",
                    dayWithSmallestTempSpread.get(WeatherDataCalculator.DAY_COLUMN));

            // Task 2: Football data
            var footballDataCalculator = new FootballDataCalculator();
            Map<String, String> teamWithSmallestGoalSpread = footballDataCalculator.calcDataWithMinSpread(footballHashMap);
            System.out.printf("Team with smallest goal spread       : %s%n",
                    teamWithSmallestGoalSpread.get(FootballDataCalculator.TEAM_COLUMN));

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
