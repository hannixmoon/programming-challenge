package de.exxcellent.challenge.calculator;

import java.util.List;
import java.util.Map;

public class FootballDataCalculator implements DataCalculator{

    public static final String TEAM_COLUMN = "Team";
    public static final String GOALS_COLUMN = "Goals";
    public static final String GOALS_ALLOWED_COLUMN = "Goals Allowed";
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
