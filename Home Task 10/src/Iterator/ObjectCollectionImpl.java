package Iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class ObjectCollectionImpl implements ObjectCollection,Iterable<Object> {

    private Object[] objectArray;
    private int count = 0;



    public ObjectCollectionImpl() {
        objectArray = new Object[10];
        count = 0;
    }

    public ObjectCollectionImpl(int size) {
        objectArray = new Object[size];
        count = 0;
    }

    @Override
    public void show() {
        for (Object o : objectArray) {
            System.out.println(o);
        }
    }

    @Override
    public boolean add(Object o) {
        if (count == objectArray.length) {
            this.objectArray = Arrays.copyOf(this.objectArray, (this.objectArray.length * 3) / 2 + 1);
            add(count, o);
        } else {
            add(count, o);
        }
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        if (index > this.count)
            throw new ArrayIndexOutOfBoundsException();
        else {
            this.objectArray = Arrays.copyOf(this.objectArray, this.objectArray.length);
            for (int i = this.objectArray.length - 1; i > index; i--) {
                objectArray[i] = objectArray[i - 1];
            }
            this.objectArray[index] = o;
            count++;

        }
        return true;
    }

    @Override
    public boolean delete(Object o) {
        for (int i = 0; i < this.objectArray.length - 1; i++) {
            if (objectArray[i] == o) {
                this.objectArray[i] = this.objectArray[i + 1];
            }
        }
        this.objectArray = Arrays.copyOf(this.objectArray, this.objectArray.length);
        objectArray[--count] = null;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index > this.count)
            throw new ArrayIndexOutOfBoundsException();
        return this.objectArray[index];
    }

    @Override
    public boolean contain(Object o) {
        for (Object object : this.objectArray) {
            if (object.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        ObjectCollection oc = (ObjectCollection) str;
        if (!(str instanceof ObjectCollection)) return false;
        if (this == str) return true;
        if (this.size() != oc.size()) return false;

        return false;
    }

    @Override
    public boolean clear() {
        this.objectArray = new Object[10];
        count = 0;

        return true;
    }

    @Override
    public int size() {
        return this.count;
    }

    public void trim() {
        if (count == 0) {
            System.out.println("Collection haven't elements");
        } else {
            this.objectArray = Arrays.copyOf(this.objectArray, count);
        }
    }


    @Override
    public Iterator<Object> iterator() {
        Iterator<Object> it = new Iterator<>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < count && objectArray[currentIndex] != null;
            }

            @Override
            public Object next() {
                return objectArray[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
