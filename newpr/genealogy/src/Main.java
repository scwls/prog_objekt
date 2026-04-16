import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            //List<Person> people = Person.fromCsv("family.csv");
            List<Person> people = Person.fromBinaryFile("data.bin");
            for(Person person: people)
                System.out.println(person);
            //Person.toBinaryFile("data.bin", people);
        } catch (IOException e) {
            System.err.println("Blad dostepu do pliku");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}