package SortingAlgos;


import org.junit.Test;

import java.util.Random;

public class SpeedComparison {


    public int[] createArray(int size, int bound){
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(bound);
        }

        return array;
    }

    public boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1] > array[i]) return false;
        }
        return true;
    }

    @Test
    public void testSpeedWithCustomNumbersAndBound() {
        double divider = 1000, startTime, endTime;
        int[] array1 = createArray(400_000_000, 25_500_000);
        /**int[] array2 = array1.clone();
        int[] array3 = array1.clone();
        int[] array4 = array1.clone();
**/
        startTime = System.currentTimeMillis();
        Mergesort.sort(array1);
        endTime = System.currentTimeMillis();
        System.out.printf("MergeSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array1));

        /**
        startTime = System.currentTimeMillis();
        InsertionSort.sort(array1);
        endTime = System.currentTimeMillis();
        System.out.printf("InsertionSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array1));

        startTime = System.currentTimeMillis();
        SelectionSort.sort(array2);
        endTime = System.currentTimeMillis();
        System.out.printf("SelectionSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array2));

        startTime = System.currentTimeMillis();
        BubbleSort.sort(array4);
        endTime = System.currentTimeMillis();
        System.out.printf("BubbleSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array4));
         */
    }
}