import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people;
        try {
            people = Person.fromCsv("family.csv");
            //people = Person.fromBinaryFile("data.bin");
            for(Person person: people)
                System.out.println(person);
            //Person.toBinaryFile("data.bin", people);
        } catch (IOException e) {
            System.err.println("Blad dostepu do pliku");
            throw new RuntimeException(e);
        }/* catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }*/
        PlantUMLRunner.setJarPath("plantuml-1.2026.2.jar");
        List<Person> filtered = Person.filterPersonBySubstring(people, "ska");
        //System.out.println(filtered);
        /*List<Person> sorted = Person.sorted(people);
        sorted.stream()
                .map(Person::name)
                .forEach(System.out::println);*/
//        List<Person> sortedDeath = Person.getDeceasedByLifespan(people);
//        sortedDeath.stream()
//                .map(Person::name)
//                .forEach(System.out::println);
        PlantUMLRunner.generate(Person.generateTree(people,text -> String.format("%s #FFFF00",text), filtered::contains),"output", "test");
        System.out.println();
        Person p = Person.getOldestLiving(people);
        System.out.println(p);


    }
}