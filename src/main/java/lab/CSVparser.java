package lab;

import java.io.Reader;
import java.nio.file.Files;
import java.util.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

/**
 * Class for reading information from csv file and returning a list of employees generated from a file
 **/
public class CSVparser {
    private String filePath;

    /**
     * Method that checks correctness of file path
     * @param path path to file
     * @return true if it's correct, false if not
     **/
    public boolean isCorrectFilePath(String path) {
        File file = new File(path);
        if (file.exists() && path.split("\\.", 2)[1].equals("csv")) {
            filePath = path;
            return true;
        }
        return false;
    }

    /**
     * Method that takes a file as input, reads and processes it
     * @throws IOException An exception that is thrown when an I/O error occurs
     * @return the list of persons (employees)
     **/
    public List<Person> fileRead() throws IOException {
        List<Person> persons = new ArrayList();

        Scanner input = new Scanner(System.in);
        String path = "";
        System.out.println("Enter file path: ");
        if (input.hasNextLine())
            path = input.nextLine();
        while (!isCorrectFilePath(path)) {
            System.out.println("Invalid input. Enter correct file path:");
            if (input.hasNextLine())
                path = input.nextLine();
        }
        return persons = parseCSV(filePath);
    }

    /**
     * Method for parsing into list
     * @param filePath path to file
     * @throws IOException An exception that is thrown when an I/O error occurs
     * @return the list of persons (employees)
     **/
    public List<Person> parseCSV(String filePath) throws IOException {
        List<Person> personsResult = new ArrayList();
        List<Department> departments = new ArrayList();
        departments.add(new Department("null", 0));
        File file = new File(filePath);
        Reader rdr = Files.newBufferedReader(file.toPath());

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        CSVReader reader = new CSVReaderBuilder(rdr)
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();

        String[] nextStr = {"hi"};

        while (nextStr != null){
            try{
                nextStr = reader.readNext();
            }
            catch (CsvValidationException e){
                System.out.println(e.getMessage());
            }
            if (nextStr != null) {
                personsResult.add(new Person(nextStr[0], nextStr[1], nextStr[2], nextStr[5], nextStr[3], nextStr[4], setDepartmentID(nextStr[4], departments)));
            }
        }
        return personsResult;
    }

    /**
     * Method for setting id for departments
     * @param dep_title name of department
     * @param deps list of departments
     * @return id of departments
     **/
    public int setDepartmentID(String dep_title, List<Department> deps) {
        int id = 0;
        for (int i = 0; i < deps.size(); i++) {
            if (Objects.equals(deps.get(i).getTitle(), dep_title)){
                return deps.get(i).getId();
            }
        }
        Random rndm = new Random();
        id = rndm.nextInt(25000);
        Department tmp = new Department(dep_title, id);
        deps.add(tmp);
        return id;
    }
}

