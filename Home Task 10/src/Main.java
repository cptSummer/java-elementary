public class Main {

    public static void main(String[] args) {
        ObjectCollectionImpl collection = new ObjectCollectionImpl();
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add("ora");
        collection.add("ora");
        collection.add("ora");
        collection.add("ora");
        collection.noDuplicates();

    }
}
