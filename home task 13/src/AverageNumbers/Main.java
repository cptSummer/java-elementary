package AverageNumbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(91);

        System.out.println(list.stream().mapToDouble(Integer::doubleValue).average());
    }
}
