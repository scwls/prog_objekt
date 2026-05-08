import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DeathCauseStatistic {
    private final String code;

    private DeathCauseStatistic(String code) {
        this.code = code;
    }

    public static record Range(int begin, int end){};

    private Map<Range, Integer> death = new HashMap<>();

    public static DeathCauseStatistic fromCsvLine (String line){
        String[] columns = line.replace("-", "0").split(",", -1);
        DeathCauseStatistic statistic = new DeathCauseStatistic(columns[0].trim());
        int begin = 0;
        int end = 4;
        for(int i=2; i< columns.length; i++){
            int number = Integer.parseInt(columns[i].trim());
//            try{number = Integer.parseInt(columns[i]);} catch (NumberFormatException e) {
//                number = 0;
//            }
            statistic.death.put(new Range(begin, end), number);
            begin += 5;
            end += 5;
        }
        return statistic;
    }

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;
        public AgeBracketDeaths(int young, int old, int deathCount ) {
            this.young = young;
            this.old = old;
            this.deathCount=deathCount;
        }
    }

    public String getCode() {
        return code;
    }

    public AgeBracketDeaths getAge(int age){
        int index = age/5;
        if(index >= death.size()){
            index=death.size()-1;
        }
        int young = index*5;
        int old = young+4;
        int count= death.getOrDefault(new Range(young, old), 0); //getOrDefault - если группы не существует, то подставляет 0ж
        return new AgeBracketDeaths(young, old, count);
    }

}
