package algo.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3, 9, 4, 6, 1, 7, 2, 5};
        System.out.println("before: " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("after: " + Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {

                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
