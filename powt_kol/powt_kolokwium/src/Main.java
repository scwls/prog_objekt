import java.nio.file.Path;
public class Main {
    public static void main(String[] args) {
        DeathCauseStatisticList statistics = DeathCauseStatisticList.fromCsv(Path.of("zgony.csv"));
        int age = 70;
        statistics.mostDeadlyDiseases(age, 10).stream()
                .forEach(stat -> System.out.println(stat.getCode() + "\t" + stat.getAge(age).deathCount));

//        DeathCauseStatistic statistic = DeathCauseStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33");
//        DeathCauseStatistic.AgeBracketDeaths abd = statistic.getAge(77);
    }
}