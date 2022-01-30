import java.util.Arrays;
import java.util.Collection;


public class OtCollection implements ObjectCollection {
    private Object[] objectArray;
    private int sizeCount;



    public OtCollection() {
        objectArray = new Object[1];
    }

    public OtCollection(int size) {
        objectArray = new Person[size];
    }

    @Override
    public void show() {
        for (Object o : objectArray) {
            System.out.println(o);
        }
    }

    @Override
    public boolean add(Object o) {
        if (sizeCount == objectArray.length - 1) {
            this.objectArray = Arrays.copyOf(this.objectArray, (this.objectArray.length * 3) / 2 + 1);
            this.objectArray[sizeCount] = o;
            sizeCount++;
        } else {
            this.objectArray[sizeCount] = o;
            sizeCount++;
        }
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        if (index > this.sizeCount)
            this.add(o);
        else {
            this.objectArray = Arrays.copyOf(this.objectArray, this.objectArray.length);
            for (int i = this.objectArray.length - 1; i > index; i--) {
                this.objectArray[i] = this.objectArray[i - 1];
            }
            this.objectArray[index] = o;
            sizeCount++;
        }
        return true;
    }

    @Override
    public boolean delete(Object o) {
        int index = 0;
        for (int i = 0; i < this.objectArray.length - 1; i++) {
            if (objectArray[i] == o) {
                index = i;
            }
        }
        for (int i = index; i < this.objectArray.length - 1; i++) {
            this.objectArray[i] = this.objectArray[i + 1];
        }
        this.objectArray = Arrays.copyOf(this.objectArray, this.objectArray.length);
        objectArray[--sizeCount] = null;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index > this.sizeCount)
            throw new ArrayIndexOutOfBoundsException();
        return this.objectArray[index];
    }

    @Override
    public boolean contain(Object o) {
        for (Object object : this.objectArray){
            if(object == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        
        return false;
    }

    @Override
    public boolean clear() {
        this.objectArray = new Person[1];
        sizeCount = 0;

        return true;
    }

    @Override
    public int size() {
        return this.sizeCount;
    }
}
