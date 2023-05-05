package lab;

import java.io.Reader;
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
    private boolean isCorrectFilePath(String path) {
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
        return persons = parse(filePath);
    }

    /**
     * Method for parsing into list
     * @param filePath path to file
     * @throws IOException An exception that is thrown when an I/O error occurs
     * @return the list of persons (employees)
     **/
    public List<Person> parse(String filePath) throws IOException {
        List<Person> personsResult = new ArrayList();
        int id;
        FileReader file = new FileReader(filePath);
        Reader rdr = new Reader(file) {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        CSVReader reader = new CSVReaderBuilder(rdr)
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();
        String[] nextStr = {""};

        do {
            try{
                nextStr = reader.readNext();
            }
            catch (CsvValidationException e){
                System.out.println(e.getMessage());
            }
            Random random = new Random();
            id = random.nextInt(25000);
            personsResult.add(new Person(nextStr[0], nextStr[1], nextStr[2], nextStr[5], nextStr[3], nextStr[4], id));
        } while (nextStr != null);
        return personsResult;
    }
}

