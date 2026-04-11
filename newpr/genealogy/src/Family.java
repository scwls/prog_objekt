import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {

    private final Map<String, List<Person>> people = new HashMap<>();

    public void add(Person... people) throws AmbiguousPersonException { // 1. Добавили throws
        for(Person person: people) {
            String key = person.name();

            if (this.people.containsKey(key)) {
                Person existingPerson = this.people.get(key).get(0);
                throw new AmbiguousPersonException(existingPerson, person);

            } else {
                List<Person> temp = new ArrayList<>();
                temp.add(person);
                this.people.put(key, temp);
            }
        }
    }

    public List<Person> get(String key) {
        return people.get(key);
    }

}
