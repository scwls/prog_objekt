import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {
    private final String  firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final LocalDate death;

    private final Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthday, LocalDate death) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death = death;
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        this(firstName, lastName, birthday, null);
    }

    public static Person fromCsvLine(String line){
        String[] columns = line.split(",", -1);
        String fullname= columns[0];
        String[] name = fullname.split(" ");
        String fname = name[0];
        String lname= name[1];
        String birth=columns[1];
        String death=columns[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdate = LocalDate.parse(birth, formatter);
        LocalDate deathdate = null;
        if(!death.isEmpty()){
            deathdate = LocalDate.parse(death, formatter);
        }
        return new Person(fname, lname, birthdate, deathdate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", death=" + death +
                ", children=" + children +
                '}';
    }


    public boolean adopt(Person child){
        if (child == this) return false;
        return children.add(child);
    }


    public Person getYoungestChild() {
        if (this.children.isEmpty()) {
            return null;
        }
        Person youngest = children.iterator().next();
        for(Person person: children) {
            if(youngest.compareTo(person)>0)
                youngest = person;
        }
        return youngest;
    }

    public List<Person> getChildren() {
        List<Person> result = new ArrayList<>();
        result.addAll(children);
        result.sort(Person::compareTo);
        return result;
    }

    public String name() {
        return String.format("%s %s",firstName, lastName);
    }

    @Override
    public int compareTo(Person other) {
        return this.birthday.compareTo(other.birthday);
    }
}