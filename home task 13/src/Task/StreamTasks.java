package Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTasks {

    public Map<String, String> pairs(List<String> list){
        return list.stream().collect(Collectors.toMap(String::toLowerCase, String::toUpperCase));
    }

    public List<String> stringFilter(List<String> list) {
        return   list.stream().
                filter(s -> s.length() == 4).
                filter(s -> s.equals(s.toLowerCase())).collect(Collectors.toList());
    }

    public double getAverage(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

    }
}
