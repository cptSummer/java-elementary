import java.util.Collection;

public interface ObjectCollection {
    boolean add(Object o);

    boolean add(int x, Object o);

    boolean delete (Object o);

    Object get(int index);

    boolean contain(Object o);

    boolean equals (Collection str);

    boolean clear();

    int size();

    void show();
}
