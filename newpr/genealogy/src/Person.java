import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public static List<Person> fromCsv(String path) throws IOException {
        ArrayList<Person> people = new ArrayList<>();
        BufferedReader file =new BufferedReader(new FileReader(path));
        String line;
        file.readLine();
        while((line = file.readLine())!=null){
            people.add(fromCsvLine(line));
        }
        file.close();
        return people;
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

//        LocalDate deathdate = null;
//        if(!death.isEmpty()){
//            deathdate = LocalDate.parse(death, formatter);
//        }
//        return new Person(fname, lname, birthdate, deathdate);

        try {
            LocalDate deathdate = LocalDate.parse(death, formatter);
            return new Person(fname, lname, birthdate, deathdate);
        }
        catch (DateTimeParseException ignored) {
            return new Person(fname, lname, birthdate);
        }
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
/*
    public Person getYoungestChild() {
        if (this.children.isEmpty()) {
            return null;
        }
        Iterator<Person> iter = this.children.iterator();
        Person now = iter.next();
        Person youngest = now;
        while (true) {
            if (youngest.birthday.compareTo(now.birthday)>0) {
                youngest=now;
            }
            try {
                now = iter.next();
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return youngest;
    }

 */

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

        //return children.stream().sorted().toList();

        //List<Person> result = new ArrayList<>(children.stream().toList());
        //result.sort(Person::compareTo);
        //return result;
    }

    public String name() {
        return String.format("%s %s",firstName, lastName);
    }

    @Override
    public int compareTo(Person other) {
        return this.birthday.compareTo(other.birthday);
    }
}