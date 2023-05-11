package lab;

import org.junit.Test;

import static lab.CSVparser.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the CSVparser class
 */
public class CSVparserTest {
    @Test
    public void isCorrectFilePathTestTrue() {
        String filePath = "C:/Users/Sofi/Desktop/foreign_names_1.csv";
        CSVparser reader = new CSVparser();
        assertTrue(reader.isCorrectFilePath(filePath));
    }

    @Test
    public void isCorrectFilePathTestFalse() {
        String filePath = "C:/Users/Sofi/Desktop/foreign_names_1.cs";
        CSVparser reader = new CSVparser();
        assertFalse(reader.isCorrectFilePath(filePath));
    }

    @Test
    public void parseCSVTest() throws IOException {
        String filePath = "C:/Users/Sofi/Desktop/foreign_names_1.csv";
        CSVparser reader = new CSVparser();
        assertEquals(25899, reader.parseCSV(filePath).size());
    }
    @Test
    public void parseCSVTest2() throws IOException {
        String filePath = "C:/Users/Sofi/Desktop/foreign_names_1.csv";
        List<Person> personsResult = new ArrayList();
        CSVparser reader = new CSVparser();
        personsResult = reader.parseCSV(filePath);
        assertEquals("Aahan", personsResult.get(1).getName());
    }

    @Test
    public void parseCSVTest3() throws IOException {
        String filePath = "C:/Users/Sofi/Desktop/foreign_names_1.csv";
        List<Person> personsResult = new ArrayList();
        CSVparser reader = new CSVparser();
        personsResult = reader.parseCSV(filePath);
        assertEquals("Male", personsResult.get(14998).getSex());
    }
}