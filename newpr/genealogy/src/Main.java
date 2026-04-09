import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //Person person = Person.fromCsvLine("Marek Kowalski,15.05.1899,,,");
        //System.out.println(person);
        try {
            List<Person> people = Person.fromCsv("family.csv");
            System.out.println(people);
        } catch (IOException e) {
            System.err.println("Blad dostepu do pliku");
        }
    }
}