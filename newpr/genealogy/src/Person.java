import java.time.LocalDate;

public class Person {
    private String firstname;
    private String lastname;
    private LocalDate birthday;

    public Person(String firstname, String lastname, LocalDate birthday) {
        this.birthday=birthday;
        this.firstname=firstname;
        this.lastname=lastname;
    }


}
