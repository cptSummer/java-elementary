public class Main {

    public static void main(String[] args) {
        Collection collection = new Collection(10);
        collection.addAsValue("a");
        collection.addAsValue("b");
        collection.addAsValue("c");
        String srt = "Enter information of students (through a space)";
        String[] words = srt.split(" ");
        for (String s : words) {
            collection.addAsValue(s);
        }
        collection.addAtIndex(5,"of");
        collection.deleteAtValue("a");
        collection.deleteAtIndex(5);
        collection.printCollection();
    }
}
