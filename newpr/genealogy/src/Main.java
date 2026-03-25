import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people= new ArrayList<>();
        people.add(new Person("Mike","Tyson", LocalDate.of(1996, 6, 18)));
        people.add(new Person("Muhammad", "Ali", LocalDate.of(1942, 1, 17)));
    }
}
