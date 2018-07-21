package algorithms.search;

/**
 * Implementation of merge sort algorithm as described in Cormen(CLRS)
 *
 * @author dmp001j
 *
 */
public class MergeSort {

    public static void main(String args[]) {

        MergeSort ms = new MergeSort();
        int[] arr = { 2, 4, 8, 3, 5, 9, 1 };

        ms.printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        ms.printArray(arr);

    }

    private void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");
    }

    private static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    /**
     * Merge function
     *
     * @param arr,
     *            original array
     * @param p,
     *            start index of first array
     * @param q,
     *            end index of first array
     * @param r,
     *            end index of array array
     */
    public static void merge(int[] arr, int p, int q, int r) {

        System.out.println("p: "+ p + " q: " + q + " r: " + r);

        final int n1 = q - p + 1;
        final int n2 = r - q;

        final int[] left = new int[n1 + 1];
        final int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[q + i + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
        }

    }
}