import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people=new ArrayList<>();
        people.add(new Person("Mike", "Tyson", LocalDate.of(1966, 5, 18)));
        people.add(new Person("Daniło", "Korzemiakin", LocalDate.of(2015, 5, 12)));
        people.add(new Person("Muhammad", "Ali", LocalDate.of(1944, 1, 2)));
        people.add(new Person("Mike", "Tyson", LocalDate.of(2000, 5, 18)));
        Person parent = people.get(0);
        Person child = people.get(1);
        System.out.println(parent.adopt(child));
        System.out.println(parent.adopt(people.get(2)));
        System.out.println(parent.getYoungestChild());

        System.out.println(parent.getChildren());

        Family family = new Family();
//        for(Person person: people) {
//            family.add(person);
//        }
        family.add(people.get(0));
        family.add(people.get(1), people.get(2),people.get(3));

        List<Person> mike = family.get("Mike Tyson");
        System.out.println(mike);

    }
}