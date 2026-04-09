import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Person person = Person.fromCsvLine("Marek Kowalski,15.05.1899,15.05.1999,,");
        System.out.println(person);
    }
}