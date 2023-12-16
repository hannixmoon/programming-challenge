package de.exxcellent.challenge.calculator;

import java.util.List;
import java.util.Map;

/**
 * The WeatherDataCalculator class implements the DataCalculator interface
 * to calculate weather-related statistics from a list of data maps.
 */
public class WeatherDataCalculator implements DataCalculator {

    public static final String DAY_COLUMN = "Day";
    public static final String MAX_TEMP_COLUMN = "MxT";
    public static final String MIN_TEMP_COLUMN = "MnT";

    /**
     * Calculates the weather data with the smallest temperature difference.
     * @param data A list of weather data maps.
     * @return The day data map with the smallest temperature difference.
     * @throws IllegalArgumentException If the input data list is null or empty or
     * if the columns for "MxT" or "MnT" are missing in the data maps.
     */
    @Override
    public Map<String, String> calcDataWithMinSpread(List<Map<String, String>> data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("The list of weather data is empty");
        }

        Map<String, String> dayWithSmallestTempSpread = data.get(0);
        int minSpread = Integer.MAX_VALUE;

        for (Map<String, String> curElem : data) {
            if (!curElem.containsKey(MAX_TEMP_COLUMN) || !curElem.containsKey(MIN_TEMP_COLUMN)) {
                throw new IllegalArgumentException("Columns for MxT or MnT in weather data are missing");
            }
            int maxTemp = Integer.parseInt(curElem.get(MAX_TEMP_COLUMN));
            int minTemp = Integer.parseInt(curElem.get(MIN_TEMP_COLUMN));
            int spread = maxTemp - minTemp;

            if (spread < minSpread) {
                minSpread = spread;
                dayWithSmallestTempSpread = curElem;
            }
        }

        return dayWithSmallestTempSpread;
    }
}
