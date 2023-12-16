package de.exxcellent.challenge.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataCalculatorTest {

    /**
     * Unit test for the WeatherDataCalculator's calcDataWithMinSpread method.
     * It tests whether the method correctly calculates the day with the minimum temperature spread
     * from a list of weather data maps.
     * The test creates a list of weather data maps, each representing a day's temperature information.
     * It then calls the calcDataWithMinSpread method and asserts that the result matches the expected day's data.
     */
    @Test
    public void testCalcDataWithMinSpread() {
        Map<String, String> weatherMap1 = new HashMap<>();
        weatherMap1.put("Day", "1");
        weatherMap1.put("MxT", "88");
        weatherMap1.put("MnT", "59");

        Map<String, String> weatherMap2 = new HashMap<>();
        weatherMap2.put("Day", "2");
        weatherMap2.put("MxT", "79");
        weatherMap2.put("MnT", "63");

        List<Map<String, String>> weatherData = new ArrayList<>();
        weatherData.add(weatherMap1);
        weatherData.add(weatherMap2);

        Map<String, String> result = new WeatherDataCalculator().calcDataWithMinSpread(weatherData);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(weatherMap2, result);
    }
}
