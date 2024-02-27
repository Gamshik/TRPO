package org.example;

public class BinarySearch {
    /**
     * Метод для бинарного поиска
     * @param arr
     * @param x
     * @return
     */
    public static int binarySearch(int[] arr, int x) {
        if(!ArraySorted.isSorted(arr))
            return -2;
        int leftBorder = 0, rightBorder = arr.length - 1;
        while (leftBorder <= rightBorder) {
            int m = (leftBorder + rightBorder ) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                leftBorder = m + 1;
            else
                rightBorder = m - 1;
        }
        return -1;
    }
}
