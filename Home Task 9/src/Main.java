import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CustomCollectionImpl collection = new CustomCollectionImpl();
        String srt = "Enter information of students (through a space)";
        String[] words = srt.split(" ");
        collection.addAll(words);
        collection.show();
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("orange");
        collection.addAll(list);
        collection.show();
        collection.delete(4);
        collection.show();
        System.out.println(collection.size());
        System.out.println();
//        collection.delete("space");
//        collection.show();
        System.out.println(collection.get(3));
        System.out.println(collection.contains("orange"));
        collection.clear();
        collection.show();
    }
}
