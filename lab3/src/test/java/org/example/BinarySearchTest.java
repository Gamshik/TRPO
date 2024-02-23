package org.example;

import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {

    public void testBinarySearch() {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;
        int result = BinarySearch.binarySearch(arr, x);
        assertEquals(3, result);
    }

    public void testBinarySearchError() {
        int[] arr = {2, 5, 4, 10, 40};
        int x = 10;
        int result = BinarySearch.binarySearch(arr, x);
        assertEquals(-1, result);
    }
}