import java.util.Collection;

public class CustomCollectionImpl implements CustomCollection {

    private Link first;
    private int id = 0;

    public CustomCollectionImpl() {
        first = null;
    }

    @Override
    public boolean add(String str) {
        id++;
        Link newLink = new Link(id, str);
        newLink.next = first;
        first = newLink;
        return true;
    }


    @Override
    public boolean addAll(String[] strArr) {
        for (String s : strArr) {
            add(s);
        }
        return true;
    }

    @Override
    public void show() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }

    }

    @Override
    public boolean addAll(Collection strColl) {
        Object[] objects = strColl.toArray();
        for (Object o : objects) {
            add(o.toString());
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        Link current = first;
        Link previous = first;
        while (current.iData != index) {
            if (current.next == null)
                return false;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        reID();
        return true;


    }

    private void reID() {
        id = id - 1;
        Link current = first;
        int i = current.iData;
        while (current != null) {
            i--;
            current.iData = i;
            current = current.next;
        }
    }

    @Override
    public boolean delete(String str) {
        Link current = first;
        int i = current.iData;
        while (current != null) {
            i--;
            if(current.dData.equals(str)){
                delete(i);
            }

            current = current.next;
        }
        return true;
    }

    @Override
    public String get(int index) {
        Link current = first;
        while (current != null) {
            if (current.iData == index) {
                return current.dData;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public boolean contains(String str) {
        Link current = first;
        while (current.dData.equals(str)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    @Override
    public boolean clear() {
        first = null;
        id = 0;
        return false;
    }

    @Override
    public int size() {
        return id;
    }

    @Override
    public boolean compare(CustomCollectionImpl coll) {

        if (this == coll) return true;
        if(this.size() != coll.size()) return false;
        for (int i = coll.size(); i < 0; i--) {
            if (!this.get(i).equals(coll.get(i))){
                return false;
            }
        }
        return true;
    }
}
