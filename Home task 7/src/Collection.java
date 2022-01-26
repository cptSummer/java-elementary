import java.util.Arrays;

public class Collection implements ICollection {
    private String[] strArray;
    private int sizeCount;

    public Collection() {
        strArray = new String[0];
    }

    public Collection(int size) {
        strArray = new String[size];
    }

    @Override
    public void printCollection() {
        for (String s : strArray) {
            System.out.println(s);
        }
    }

    @Override
    public boolean addAtIndex(int index, String value) {
        if (index > this.sizeCount)
            this.addAsValue(value);
        else {
            this.strArray = Arrays.copyOf(this.strArray, this.strArray.length);
            for (int i = this.strArray.length - 1; i > index; i--) {
                this.strArray[i] = this.strArray[i - 1];
            }
            this.strArray[index] = value;
            sizeCount++;
        }
        return true;
    }

    public boolean addAsValue(String element) {
        if (sizeCount == strArray.length - 1) {
            this.strArray = Arrays.copyOf(this.strArray, (this.strArray.length * 3) / 2 + 1);
            this.strArray[sizeCount] = element;
            sizeCount++;
        } else {
            this.strArray[sizeCount] = element;
            sizeCount++;
        }
        return true;
    }

    @Override
    public boolean deleteAtIndex(int index) {
        if (index > this.sizeCount)
            return false;
        else {
            for (int i = index; i < this.strArray.length - 1; i++) {
                this.strArray[i] = this.strArray[i + 1];
            }

            this.strArray = Arrays.copyOf(this.strArray, this.strArray.length);
            strArray[--sizeCount] = null;
        }
        return true;
    }

    @Override
    public boolean deleteAtValue(String value) {
        int index = 0;

        for (int i = 0; i < this.strArray.length - 1; i++) {
            if (strArray[i] == value) {
                index = i;
            }
        }
        for (int i = index; i < this.strArray.length - 1; i++) {
            this.strArray[i] = this.strArray[i + 1];
        }

        this.strArray = Arrays.copyOf(this.strArray, this.strArray.length);
        strArray[--sizeCount] = null;
        return true;
    }

    @Override
    public String get(int index) {
        if (index > this.sizeCount)
            throw new ArrayIndexOutOfBoundsException();
        return this.strArray[index];
    }

    @Override
    public String toString() {
        return "Collection{" +
                "strArray=" + Arrays.toString(strArray) +
                ", sizeCount=" + sizeCount +
                '}';
    }
}
