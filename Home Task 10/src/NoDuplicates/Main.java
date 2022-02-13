package NoDuplicates;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        NoDuplicates noDuplicates = new NoDuplicates();
        System.out.println(noDuplicates.removeDuplicates(list));
    }


}
