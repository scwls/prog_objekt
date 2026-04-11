import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = null;

        try {
            people = Person.fromCsv("family.csv");

            System.out.println("--- Lista wczytanych osób ---");
            if (people != null) {
                for (Person p : people) {
                    System.out.println(p);
                }
            }
            Family family = new Family();

            if (people != null) {
                for (Person p : people) {
                    try {
                        family.add(p);
                    } catch (AmbiguousPersonException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Błąd dostępu do pliku: " + e.getMessage());
        }
    }
}