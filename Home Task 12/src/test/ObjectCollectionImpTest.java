package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import program.ObjectCollectionImpl;

public class ObjectCollectionImpTest {
    private ObjectCollectionImpl collection;

    @Before
    public void setUp() {
        collection = new ObjectCollectionImpl(20);
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(5);
        collection.add(5);
        collection.add(4);//6
    }

    @Test
    public void collectionClear() {
        collection.clear();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    public void collectionAdd(){
        collection.add("3444");
        Assertions.assertEquals("3444",collection.get(6));
        Assertions.assertEquals(7,collection.size());
    }

    @Test
    public void collectionAddIndex(){
        collection.add(3,"4444");
        Assertions.assertEquals("4444",collection.get(3));
        Assertions.assertEquals(7,collection.size());

    }
    @Test
   public void collectionAddIndex_Exception() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            collection.add(30,"4444");
        });
    }

    @Test
    public void collectionDelete_True(){
        Assertions.assertTrue(collection.delete(5));
        Assertions.assertEquals(5,collection.size());
    }

    @Test
    public void collectionContains_True(){
        Assertions.assertTrue(collection.contain(5));
    }

    @Test
    public void collectionEquals_True(){
        Assertions.assertTrue(collection.equals(collection));
    }
}
