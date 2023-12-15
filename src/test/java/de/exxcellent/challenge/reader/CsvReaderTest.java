package de.exxcellent.challenge.reader;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvReaderTest {

    @Disabled
    @Test
    void emptyFilePath() {
        assertNotNull(CsvReader.readCsvFile("")); }

    @Disabled
    @Test
    void emptyCsvFile() {
        assertNotNull(CsvReader.convertCsvToMap(null));
    }
}
