import java.util.Collection;

public class OtCollection implements ObjectCollection{
    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean add(int x, Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean contain(Object o) {
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
