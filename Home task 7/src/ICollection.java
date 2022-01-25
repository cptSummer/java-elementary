public interface ICollection {
    boolean addAtIndex(int index, String value);

    boolean addAsValue(String value);

    boolean deleteAtIndex(int index);

    boolean deleteAtValue(String value);

    String get(int index);

    void printCollection();
}
