package Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StreamTasks streamTasks = new StreamTasks();
        ArrayList<Double> listDou = new ArrayList<>();
        ArrayList<String> listStr = new ArrayList<>();

        listDou.add(1.0);
        listDou.add(5.0);
        listDou.add(5.0);
        listDou.add(1.0);
        listStr.add("1234");
        listStr.add("name");
        listStr.add("Collossal");
        listStr.add("Bigger");
        System.out.println(streamTasks.stringFilter(listStr));
        System.out.println(streamTasks.pairs(listStr));
        System.out.println(streamTasks.getAverage(listDou));
    }
}
