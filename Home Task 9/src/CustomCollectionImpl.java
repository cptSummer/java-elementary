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
        for (int i = 0; i < strArr.length; i++) {
            add(strArr[i]);
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
        System.out.println("");
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
        Link previous = first;
        while (str.equals(current.dData)) {
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
    public boolean compare(Collection coll) {
        CustomCollection oc = (CustomCollection) coll;
        int lenA = this.size();
        int lenB = oc.size();
        Link currentA = first;
        Link currentB = first;
        if(lenA > lenB || lenA < lenB){
            return false;
        }
        while (currentA != null && currentB != null)
        {
            if (currentA.iData > currentB.iData)
                return false;
            else if (currentA.iData < currentB.iData)
                return false;

            currentA = currentA.next;
            currentB = currentB.next;
        }

        return true;
    }
}
