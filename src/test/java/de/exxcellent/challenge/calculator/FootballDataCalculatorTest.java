package de.exxcellent.challenge.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FootballDataCalculatorTest {

    @Test
    public void testCalcDataWithMinSpread() {
        Map<String, String> footballMap1 = new HashMap<>();
        footballMap1.put("Team", "Arsenal");
        footballMap1.put("Goals", "79");
        footballMap1.put("Goals Allowed", "36");

        Map<String, String> footballMap2 = new HashMap<>();
        footballMap2.put("Team", "Liverpool");
        footballMap2.put("Goals", "67");
        footballMap2.put("Goals Allowed", "30");

        List<Map<String, String>> footballData = new ArrayList<>();
        footballData.add(footballMap1);
        footballData.add(footballMap2);

        Map<String, String> result = new FootballDataCalculator().calcDataWithMinSpread(footballData);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(footballMap2, result);
    }
}
