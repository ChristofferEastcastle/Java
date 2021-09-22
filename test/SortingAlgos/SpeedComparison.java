package SortingAlgos;


import org.testng.annotations.Test;

import java.util.Random;

public class SpeedComparison {


    public Integer[] createArray(int size, int bound){
        Integer[] array = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(bound);
        }

        return array;
    }

    private <T extends Comparable<T>>  boolean isSorted(T[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1].compareTo(array[i]) > 0) return false;
        }
        return true;
    }

    @Test
    public void testSpeedWithCustomNumbersAndBound() {
        double divider = 1000, startTime, endTime;
        Integer[] array1 = createArray(10_000_000, 2_500_000);
        //Integer[] array3 = array1.clone();
        //int[] array2 = array1.clone();
        //int[] array4 = array1.clone();


        QuickSort quickSort = new QuickSort();
        startTime = System.currentTimeMillis();
        quickSort.sort(array1);
        endTime = System.currentTimeMillis();
        System.out.printf("QuickSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array1));

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
        System.out.printf("BubbleSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array2));

        startTime = System.currentTimeMillis();
        BubbleSort.sort(array4);
        endTime = System.currentTimeMillis();
        System.out.printf("BubbleSort: %.3fs | isSorted = %s\n", (endTime - startTime) / divider, isSorted(array4));
    */
         }
}