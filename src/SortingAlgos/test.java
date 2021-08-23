package SortingAlgos;

import java.util.Random;

import static SortingAlgos.Mergesort.*;

public class test {
    public static void main(String[] args) {


        int size = 10000;
        int bound = 25000;

        int[] arr = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(bound);
        }

        sort(arr);
        print(arr);
    }
}
