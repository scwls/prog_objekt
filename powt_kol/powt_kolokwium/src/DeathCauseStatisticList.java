import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DeathCauseStatisticList {
    private List<DeathCauseStatistic> statistics;
    public static DeathCauseStatisticList fromCsv(Path path){
        DeathCauseStatisticList result = new DeathCauseStatisticList();
        try {
            result.statistics=Files.lines(path)
                    .skip(1)
                    .map(DeathCauseStatistic::fromCsvLine)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        return statistics.stream()
                .sorted((stat1, stat2) ->
                        Integer.compare(stat2.getAge(age).deathCount, stat1.getAge(age).deathCount)
                ).limit(n).toList();

    }
}
