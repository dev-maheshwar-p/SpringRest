package algorithms.search;/* Iterative Java program for merge sort */

import java.lang.Math.*;

class MergeSortEasierImplementationNonRecursive {

    static void mergeSort(int arr[], int n) {

        int right;
        int left;

        for (right = 1; right <= n - 1; right = 2 * right) {
            for (left = 0; left < n - 1; left = left + 2 * right) {

                System.out.println("The right and left indexes are : " + right + " & " + left);

                int mid = left + right - 1;
                int right_end = Math.min(left + 2 * right - 1, n - 1);
                merge(arr, left, mid, right_end);
            }
        }
    }

    static void merge(int arr[], int l, int m, int r) {

        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
     

        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];

        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        
        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    /* Function to print an array */
    static void printArray(int A[], int right) {
        int i;

        for (i = 0; i < right; i++)
            System.out.printf("%d ", A[i]);

        System.out.printf("\n");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.printf("Given array is \n");
        printArray(arr, n);

        mergeSort(arr, n);

        System.out.printf("\nSorted array is \n");
        printArray(arr, n);
    }
}