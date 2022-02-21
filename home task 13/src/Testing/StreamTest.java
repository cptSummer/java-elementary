package Testing;

import Task.StreamTasks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StreamTest {
    StreamTasks streamTasks = new StreamTasks();


    @Test
    public void averageNumTest() {
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(4.0);
        list.add(5.0);
        list.add(2.0);
        Assertions.assertEquals(3.0, streamTasks.getAverage(list));
    }

    @Test
    public void filterTest_Equals() {
        List<String> actual = new ArrayList<>();
        List<String> excepted = new ArrayList<>();
        actual.add("1234");
        excepted.add("1234");
        actual.add("name");
        excepted.add("name");

        Assertions.assertEquals(excepted, streamTasks.stringFilter(actual));
    }

    @Test
    public void filterTest_NotEquals() {
        List<String> actual = new ArrayList<>();
        List<String> notExcepted = new ArrayList<>();
        actual.add("ambasador");
        notExcepted.add("ambasador");
        actual.add("Name");
        notExcepted.add("Name");
        Assertions.assertNotEquals(notExcepted, streamTasks.stringFilter(actual));
    }

    @Test
    public void pairsTest() {
        List<String> actual = new ArrayList<>();
        HashMap<String, String> excepted = new HashMap<>();
        actual.add("name");
        excepted.put("name", "NAME");

        Assertions.assertEquals(excepted, streamTasks.pairs(actual));
    }

}
