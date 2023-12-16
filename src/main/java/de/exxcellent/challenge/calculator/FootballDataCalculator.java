package de.exxcellent.challenge.calculator;

import java.util.List;
import java.util.Map;

/**
 * The FootballDataCalculator class implements the DataCalculator interface
 * to calculate football-related statistics from a list of data maps.
 */
public class FootballDataCalculator implements DataCalculator {

    public static final String TEAM_COLUMN = "Team";
    public static final String GOALS_COLUMN = "Goals";
    public static final String GOALS_ALLOWED_COLUMN = "Goals Allowed";

    /**
     * Calculates the team data with the smallest (absolut) goal difference.
     * @param data A list of football data maps.
     * @return The team data map with the smallest goal difference.
     * @throws IllegalArgumentException If the input data list is null or empty or
     * if the columns for "Goals" or "Goals Allowed" are missing in the data maps.
     */
    @Override
    public Map<String, String> calcDataWithMinSpread(List<Map<String, String>> data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("The list of football data is empty");
        }

        Map<String, String> teamWithSmallestGoalSpread = data.get(0);
        int minSpread = Integer.MAX_VALUE;

        for (Map<String, String> curElem : data) {
            if (!curElem.containsKey(GOALS_COLUMN) || !curElem.containsKey(GOALS_ALLOWED_COLUMN)) {
                throw new IllegalArgumentException("Columns for Goals or Goals Allowed in football data are missing");
            }
            int goals = Integer.parseInt(curElem.get(GOALS_COLUMN));
            int goalsAllowed = Integer.parseInt(curElem.get(GOALS_ALLOWED_COLUMN));
            int spread = Math.abs(goals - goalsAllowed);

            if (spread < minSpread) {
                minSpread = spread;
                teamWithSmallestGoalSpread = curElem;
            }
        }

        return teamWithSmallestGoalSpread;
    }
}
