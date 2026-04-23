import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PersonWithParentStrings {

    private Person person;
    private String[] parents;

    public PersonWithParentStrings(Person person, String[] parents) {
        this.person = person;
        this.parents = parents;
    }

    public static PersonWithParentStrings fromCsvLine(String line) throws NegativeLifespanException {
        Person person = Person.fromCsvLine(line);
        String[] columns = line.split(",", -1);
        return new PersonWithParentStrings(person, Arrays.copyOfRange(columns, 3, 5));
    }

    public String name(){
        return this.person.name();
    }

    public static void connectRelatives(Map<String, PersonWithParentStrings> peopleMap) {
        for (PersonWithParentStrings childWrapper : peopleMap.values()) {
            for (String parentString : childWrapper.parents) {
                if (parentString != null && !parentString.trim().isEmpty()) {
                    String cleanParentName = parentString.trim();
                    PersonWithParentStrings parentWrapper = peopleMap.get(cleanParentName);

                    if (parentWrapper != null) {
                        try {
                            parentWrapper.person.adopt(childWrapper.person);
                        } catch (Exception e) {
                            System.err.println("Błąd podczas łączenia " + cleanParentName + " i " + childWrapper.name() + ": " + e.getMessage());
                        }
                    } else {
                        System.err.println("Uwaga: Krewny '" + cleanParentName + "' nie został znaleziony dla " + childWrapper.name());
                    }
                }
            }
        }
    }

    public static List<Person> unpackMap(Map<String, PersonWithParentStrings> people){
        ArrayList<Person> peopleResult = new ArrayList<>();
        for (PersonWithParentStrings personWithParentStrings : people.values()){
            peopleResult.add(personWithParentStrings.person);
        }
        return peopleResult;
    }

}