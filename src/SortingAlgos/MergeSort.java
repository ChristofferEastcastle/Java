package SortingAlgos;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] array){
        sort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int left, int right) {
        if (left < right) {

            int mid = left + (right - left) / 2;

            sort(array, left, mid);
            sort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        System.arraycopy(array, left, L, 0, n1);

        for (int j = 0; j < n2; ++j) R[j] = array[mid + 1 + j];


        int i = 0, j = 0, k;

        k = left;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) < 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }


    public static void print(int[] array){
        for (int i = 0; i < array.length; i++){
            if (i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
