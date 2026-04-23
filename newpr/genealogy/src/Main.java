import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. СНАЧАЛА читаем из твоего CSV файла (убедись, что путь к CSV правильный!)
            List<Person> people = Person.fromCsv("family.csv");

            // 2. СОХРАНЯЕМ эти данные в бинарный файл (это создаст data.bin)
            Person.toBinaryFile("data.bin", people);

            System.out.println("Файл data.bin успешно создан!");

            for(Person person: people) {
                System.out.println(person);
            }
        } catch (IOException e) {
            System.err.println("Ошибка файла: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Другая ошибка: " + e.getMessage());
        }

        PlantUMLRunner.setJarPath("D:/Studia/programowanie objektowe/newpr/genealogy/plantuml-1.2026.2.jar");

        PlantUMLRunner.generate(
                "@startuml\n" +
                        "Alice->Bob : Hello\n" +
                        "return ok\n" +
                        "@enduml",
                "output",
                "test"
        );
    }
}
