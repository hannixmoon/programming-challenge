package de.exxcellent.challenge.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {

    public static List<Map<String, String>> readCsvFile(String csvFilePath) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> csvData = reader.readAll();

            if (csvData == null || csvData.size() < 2) {
                throw new RuntimeException("CSV file is empty or contains only the header");
            }

            dataList = convertCsvToMap(csvData);
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return dataList;
    }

    public static List<Map<String, String>> convertCsvToMap(List<String[]> csvData) {
        List<Map<String, String>> dataList = new ArrayList<>();

        // Assuming the first row contains column headers
        String[] headers = csvData.get(0);

        for (int i = 1; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            if (row.length != headers.length) {
                System.err.println("Mismatched number of columns in a row. Skipping the row.");
                continue;
            }
            Map<String, String> rowMap = new HashMap<>();

            for (int j = 0; j < headers.length; j++) {
                rowMap.put(headers[j], row[j]);
            }

            dataList.add(rowMap);
        }
        return dataList;
    }
}
