package Filter;

import java.util.ArrayList;
import java.util.List;


public class Filter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1234");
        list.add("name");
        list.add("Double");

        stringFilter(list);

    }

    private static void stringFilter(List<String> list) {
        list.stream().
                filter(s -> s.length() == 4).
                filter(s -> s.equals(s.toLowerCase()))
                .forEach(System.out::println);
    }

}
