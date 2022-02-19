package AverageNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class AverageNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(91);

        System.out.println(getAverage(list));
    }

    public static OptionalDouble getAverage(List<Integer> list) {
        return list.stream().mapToDouble(Integer::doubleValue).average();
    }


}
