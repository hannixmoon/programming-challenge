package de.exxcellent.challenge.calculator;

import java.util.List;
import java.util.Map;

public class WeatherDataCalculator implements DataCalculator{

    public static final String DAY_COLUMN = "Day";
    public static final String MAX_TEMP_COLUMN = "MxT";
    public static final String MIN_TEMP_COLUMN = "MnT";

    @Override
    public Map<String, String> calcDataWithMinSpread(List<Map<String, String>> weatherData) {
        if (weatherData == null || weatherData.isEmpty()) {
            throw new IllegalArgumentException("The list of weather data is empty");
        }

        Map<String, String> dayWithSmallestTempSpread = weatherData.get(0);
        int minSpread = Integer.MAX_VALUE;

        for (Map<String, String> curElem : weatherData) {
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
