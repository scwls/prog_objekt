import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Person implements Comparable<Person>, Serializable {
    private final String  firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final LocalDate death;


    private final Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthday, LocalDate death) throws NegativeLifespanException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death = death;
        if(this.death !=null && this.birthday.isAfter(this.death)){
            throw new NegativeLifespanException(this);
        }
    }


    public Person(String firstName, String lastName, LocalDate birthday) throws NegativeLifespanException {
        this(firstName, lastName, birthday, null);
    }

    public static List<Person> fromCsv(String path) throws IOException {
        Map<String, PersonWithParentStrings> people = new HashMap<>();
        BufferedReader file =new BufferedReader(new FileReader(path));
        String line;
        file.readLine();
        while((line = file.readLine())!=null){
            try {
                PersonWithParentStrings newperson = PersonWithParentStrings.fromCsvLine(line);
                /*for(PersonWithParentStrings person: people){
                    if(person.name().equals(newperson.name())){
                        throw new AmbiguousPersonException(person, newperson);
                    }
                }*/
                people.put(newperson.name(), newperson);
            } catch (NegativeLifespanException/* | AmbiguousPersonException*/ e) {
                System.err.println(e.getMessage());
            }
        }
        file.close();
        PersonWithParentStrings.connectRelatives(people);
        return PersonWithParentStrings.unpackMap(people);
    }

    public static Person fromCsvLine(String line) throws NegativeLifespanException {
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

    String negativeLifespanExceptionMessage(){
        return String.format("Osoba %s %s ma datę śmierci %s wcześniejszą niż datę urodzenia %s",
                this.firstName, this.lastName, this.death, this.birthday);
    }
    public static void toBinaryFile(String path, List<Person> people) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(people);
        oos.close();
    }
    public  static List<Person> fromBinaryFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Person> people = (ArrayList<Person>) ois.readObject();
        ois.close();
        return people;
    }
}