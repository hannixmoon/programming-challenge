package de.exxcellent.challenge.reader;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CsvFileReaderTest {

    /**
     * It is expected that a potential FileNotFoundException will be caught
     * and the error message and stack trace are being printed.
     */
    @Test
    void testInvalidFilePathExceptionCaught() {
        String filePath = "invalid";
        var fileReader = new CsvFileReader();

        assertDoesNotThrow(() -> {
            fileReader.readFile(filePath);
        });
    }

    @Test
    void testReadCsvFile() {
        String weatherFilePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        List<Map<String, String>> weatherData = new CsvFileReader().readFile(weatherFilePath);

        assertNotNull(weatherData);
        assertFalse(weatherData.isEmpty());
        assertEquals("1", weatherData.get(0).get("Day"));
    }

    @Test
    void testConvertCsvToMap() {
        List<String[]> testData = List.of(
                new String[]{"Day", "MxT", "MnT"},
                new String[]{"1", "25", "64"},
                new String[]{"2", "30", "58"}
        );

        List<Map<String, String>> weatherData = CsvFileReader.convertCsvToMap(testData);

        assertNotNull(weatherData);
        assertFalse(weatherData.isEmpty());
        assertEquals("1", weatherData.get(0).get("Day"));
        assertEquals(2, weatherData.size());
    }
}
