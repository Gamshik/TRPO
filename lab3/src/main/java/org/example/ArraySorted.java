package org.example;

public class ArraySorted {
    /**
     * Метод для проверки на отсортированный массив
     * @param array
     * @return
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
