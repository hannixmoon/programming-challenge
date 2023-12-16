package de.exxcellent.challenge.calculator;

import java.util.List;
import java.util.Map;

/**
 * Interface for classes that perform calculations on a list of data maps.
 */
public interface DataCalculator {

    Map<String, String> calcDataWithMinSpread(List<Map<String, String>> data);
}
