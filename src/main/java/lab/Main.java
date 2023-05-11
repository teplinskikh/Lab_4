package lab;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {
    /**
     * main method
     * @param args the Main arguments
     * @throws IOException An exception that is thrown when an I/O error occurs
     */
    public static  void main(String[] args) throws IOException {
        List<Person> persons;
        String exit_code = "";
        CSVparser reader = new CSVparser();
        Scanner input = new Scanner(System.in);
        while (!Objects.equals(exit_code, "exit")){
            persons = reader.fileRead();

            for (int i = 1; i < persons.size(); i++)
                System.out.println(persons.get(i).getPerson());
            System.out.println("Enter 'exit' to exit.");
            exit_code = input.nextLine();
        }
    }
}