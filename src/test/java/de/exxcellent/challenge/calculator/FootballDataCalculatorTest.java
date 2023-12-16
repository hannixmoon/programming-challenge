package de.exxcellent.challenge.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FootballDataCalculatorTest {

    /**
     * Unit test for the FootballDataCalculator's calcDataWithMinSpread method.
     * It tests whether the method correctly calculates the team with the minimum goal difference
     * from a list of football data maps.
     * The test creates a list of football data maps, each representing a team's goal information.
     * It then calls the calcDataWithMinSpread method and asserts that the result matches the expected team's data.
     */
    @Test
    public void testCalcDataWithMinSpread() {
        Map<String, String> footballMap1 = new HashMap<>();
        footballMap1.put("Team", "Arsenal");
        footballMap1.put("Goals", "79");
        footballMap1.put("Goals Allowed", "36");

        Map<String, String> footballMap2 = new HashMap<>();
        footballMap2.put("Team", "Liverpool");
        footballMap2.put("Goals", "30");
        footballMap2.put("Goals Allowed", "67");

        List<Map<String, String>> footballData = new ArrayList<>();
        footballData.add(footballMap1);
        footballData.add(footballMap2);

        Map<String, String> result = new FootballDataCalculator().calcDataWithMinSpread(footballData);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(footballMap2, result);
    }
}
