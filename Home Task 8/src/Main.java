public class Main {

    public static void main(String[] args) {
        ObjectCollectionImpl collection = new ObjectCollectionImpl();
        ObjectCollectionImpl collection1 = new ObjectCollectionImpl();
        Person person1 = new Person("Alex", "James", 40);
        Person person3 = new Person("Alex", "James", 40);
        Person person2 = new Person("Mariya", "Alfred", 35);
        collection.add(person1);
        collection.add(person2);
        collection.add(person2);
        collection.add(person2);
        collection1.add(person1);
        collection1.add(person2);
        collection1.add(person2);
        collection1.add(person2);
        collection.show();
        System.out.println();
        collection.add(1,"seadog");
        collection1.add(1,"seadog");
        collection.add(person1);
        collection1.add(person1);
        collection.show();
        System.out.println(collection.size());
        System.out.println(collection.contain("seadog"));
        System.out.println(collection1.equals(collection));

    }

}
