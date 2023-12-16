package de.exxcellent.challenge.reader;

import java.util.List;
import java.util.Map;

/**
 * Interface for classes that read a file and return its content as a list of data maps.
 */
public interface FileReader {

    List<Map<String, String>> readFile(String filePath);
}
