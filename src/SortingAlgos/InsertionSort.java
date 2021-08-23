package SortingAlgos;

import java.util.Random;

public class InsertionSort {

    public static void sort(int[] array) {

        int i, j;
        for (i = 1; i < array.length; i++) {
            int key = array[i];

            j = i - 1;
            while (j >= 0 && key < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Random rd = new Random();

        int size = 200;
        int bound = 5000;

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rd.nextInt(bound);
        }

        Mergesort.print(array);
        sort(array);

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1)
                System.out.printf("%d, ", array[i]);
            else
                System.out.printf("%d", array[i]);
        }
    }
}
