package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListPerformanceTestTest {

    private static final int TEST_SIZE = 1000;

    @Test
    public void testArrayListPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        performTests(arrayList, "ArrayList");
    }

    @Test
    public void testLinkedListPerformance() {
        List<Integer> linkedList = new LinkedList<>();
        performTests(linkedList, "LinkedList");
    }

    private void performTests(List<Integer> list, String listType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        long addTime = endTime - startTime;

        assertEquals(TEST_SIZE, list.size(), "Size of the list after adding elements should be equal to TEST_SIZE");

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = TEST_SIZE - 1; i >= 0; i--) {
            list.remove(i);
        }
        endTime = System.nanoTime();
        long removeTime = endTime - startTime;

        assertEquals(0, list.size(), "Size of the list after removing elements should be 0");

    }
}