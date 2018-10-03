package algorithms.search;

public class MergeSortEasierImplementationNonRecursive2 {

    public static void printArray(int[] array){
        for(int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    @SuppressWarnings("Duplicates")
    public static void mergeSort(int[] array) {

        if(array.length < 2) {
            return;
        }

        for (int step = 1 ; step < array.length; step *=2) {

            int startL = 0;
            int startR = step;

            while (startR + step <= array.length) {

                mergeArrays(array, startL, startL + step, startR, startR + step);

                startL = startR + step;
                startR = startL + step;

            }
            if (startR < array.length) {
                mergeArrays(array, startL, startL + step, startR, array.length);
            }

        }
    }

    @SuppressWarnings("Duplicates")
    public static void mergeArrays(int[] array, int startL, int stopL, int startR, int stopR) {

        int[] right = new int[stopR - startR + 1];
        int[] left = new int[stopL - startL + 1];

        for(int i = 0, k = startR; i < (right.length - 1); ++i, ++k) {
            right[i] = array[k];
        }

        for(int i = 0, k = startL; i < (left.length - 1); ++i, ++k) {
            left[i] = array[k];
        }

        right[right.length-1] = Integer.MAX_VALUE;
        left[left.length-1] = Integer.MAX_VALUE;

        for(int k = startL, m = 0, n = 0; k < stopR; ++k) {
            if(left[m] <= right[n]) {
                array[k] = left[m];
                m++;
            }
            else {
                array[k] = right[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[] {12, 11, 13, 5, 6, 7, 12, 11, 13, 5, 6, 7, 12, 11, 13, 5, 6, 7};
        int[] array = {5,2,4,1,3,6};
        mergeSort(array);
        printArray(array);
    }
}