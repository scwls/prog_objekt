import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mike","Tyson", LocalDate.of(1996, 6, 18)));
        people.add(new Person("Muhammad", "Ali", LocalDate.of(2012, 1, 17)));
        people.add(new Person("Тike","Tyson", LocalDate.of(2008, 6, 18)));
        people.add(new Person("Max", "Ali", LocalDate.of(2007, 1, 17)));
        Person parent = people.get(0);
        Person child = people.get(1);
        Person child1 = people.get(2);
        Person child2 = people.get(3);
        parent.adopt(child);
        parent.adopt(child1);
        parent.adopt(child2);
        System.out.println(parent.adopt(parent));
        System.out.println(people);
        System.out.println(parent.getYoungestChild());
    }
}
