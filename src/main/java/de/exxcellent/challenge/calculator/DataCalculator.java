package de.exxcellent.challenge.calculator;

import java.util.List;
import java.util.Map;

public interface DataCalculator {

    Map<String, String> calcDataWithMinSpread(List<Map<String, String>> data);
}
