import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class OtCollection implements ObjectCollection {
    private Person[] personArray;
    private int sizeCount;
    Scanner sc = new Scanner(System.in);


    public OtCollection() {
        personArray = new Person[0];
    }

    public OtCollection(int size) {
        personArray = new Person[size];
    }

    @Override
    public void show() {
        for (Object o : personArray) {
            System.out.println(o);
        }
    }

    @Override
    public boolean add(Object o) {
        Person person = (Person) o;
        if (sizeCount == personArray.length - 1) {
            this.personArray = Arrays.copyOf(this.personArray, (this.personArray.length * 3) / 2 + 1);
            this.personArray[sizeCount] = person;
            sizeCount++;
        } else {
            this.personArray[sizeCount] = person;
            sizeCount++;
        }
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        Person person = (Person) o;
        if (index > this.sizeCount)
            this.add(person);
        else {
            this.personArray = Arrays.copyOf(this.personArray, this.personArray.length);
            for (int i = this.personArray.length - 1; i > index; i--) {
                this.personArray[i] = this.personArray[i - 1];
            }
            this.personArray[index] = person;
            sizeCount++;
        }
        return true;
    }

    @Override
    public boolean delete(Object o) {
        Person person = (Person) o;
        int index = 0;
        for (int i = 0; i < this.personArray.length - 1; i++) {
            if (personArray[i] == person) {
                index = i;
            }
        }
        for (int i = index; i < this.personArray.length - 1; i++) {
            this.personArray[i] = this.personArray[i + 1];
        }
        this.personArray = Arrays.copyOf(this.personArray, this.personArray.length);
        personArray[--sizeCount] = null;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index > this.sizeCount)
            throw new ArrayIndexOutOfBoundsException();
        return this.personArray[index];
    }

    @Override
    public boolean contain(Object o) {

        for (Person person : this.personArray) {
            if (person == o)
                return true;
        }

        return false;
    }

    @Override
    public boolean equals(Collection str) {
        if (this == str)
            return true;
        return false;
    }

    @Override
    public boolean clear() {
        this.personArray = new Person[0];
        sizeCount = 0;

        return true;
    }

    @Override
    public int size() {
        return this.personArray.length;
    }
}
