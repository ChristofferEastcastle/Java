package SortingAlgos;

import java.util.Random;

public class SelectionSort {

    public static void sort(int[] array) {

        int temp, step = 0, index = 0;

        while (step < array.length) {
            int min = array[step];

            for (int i = step; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    index = i;
                }
            }
            temp = array[step];
            array[step] = min;
            array[index] = temp;
            step++;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int size = 500, bound = 5000;

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(bound);
        }

        Mergesort.print(arr);
        sort(arr);
        Mergesort.print(arr);
    }
}
