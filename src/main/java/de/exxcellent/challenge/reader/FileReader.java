package de.exxcellent.challenge.reader;

import java.util.List;
import java.util.Map;

public interface FileReader {

    List<Map<String, String>> readFile(String filePath);
}
