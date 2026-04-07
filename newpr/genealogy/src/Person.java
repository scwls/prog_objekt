import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private final String firstname;
    private final String lastname;
    private final LocalDate birthday;
    private final Set<Person> children = new HashSet<>();

    public Person(String firstname, String lastname, LocalDate birthday) {
        this.birthday=birthday;
        this.firstname=firstname;
        this.lastname=lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", children=" + children +
                '}';
    }

    public Person getYoungestChild(){
        if(this.children.isEmpty()){
            return null;
        }
        Person youngest=children.iterator().next();
        for(Person person: children){
            if (youngest.birthday.compareTo(person.birthday)>0){
                youngest=person;
            }
        }
        return youngest;
    }


    public boolean adopt(Person child){
        if(child==this)return false;
        return children.add(child);
    }
}
