public class Main {

    public static void main(String[] args) {
        OtCollection collection = new OtCollection();
        Person person1 = new Person("Alex", "James", 40);
        Person person3 = new Person("Alex", "James", 40);
        Person person2 = new Person("Mariya", "Alfred", 35);
        collection.add(person1);
        collection.add(person2);
        collection.add(100,person3);
        collection.show();
//        System.out.println(person1.equals(person2));
//        System.out.println(person1.equals(person3));
        collection.add("seadog");
        collection.show();
        System.out.println(collection.contain("seadog"));

    }

}
