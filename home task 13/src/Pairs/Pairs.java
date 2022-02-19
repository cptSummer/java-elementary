package Pairs;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Pairs {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("adadd");
        list.add("two");
        System.out.println(pairs(list));

    }
    public static Map<String, String> pairs(ArrayList<String> list){
        return list.stream().collect(Collectors.toMap(String::toLowerCase, String::toUpperCase));
    }
}
