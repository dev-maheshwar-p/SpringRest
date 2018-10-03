package algorithms.search;

import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class MergeSortEasierImplementationNonRecursive3 {

    // Print Array
    public static void printArray(int[] array){
        for(int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }



    // Bottom-up merge sort
    public static void mergeSort(int[] array) {
        if(array.length < 2) {
            // We consider the array already sorted, no change is done
            return;
        }
        // The size of the sub-arrays . Constantly changing .
//        int step = 1;
        // startL - start index for left sub-array
        // startR - start index for the right sub-array
//        int startL, startR;

        for(int step =1; step < array.length; step *=2){

            int startL = 0;
            int startR = step;

            System.out.printf("- - - with step = %d ", step);
            System.out.println();

            while(startR + step <= array.length) {

                mergeArrays(array, startL, startL + step, startR, startR + step);

                System.out.printf("startL=%d, stopL=%d, startR=%d, stopR=%d",
                        startL, startL + step, startR, startR + step);
                System.out.println();

                startL = startR + step;
                startR = startL + step;

            }

            if(startR < array.length) {

                mergeArrays(array, startL, startL + step, startR, array.length);

                System.out.printf("* startL=%d, stopL=%d, startR=%d, stopR=%d",
                        startL, startL + step, startR, array.length);
                System.out.println();

            }
        }

    }

    // Merge to already sorted blocks
    public static void mergeArrays(int[] array, int startL, int stopL,
                                   int startR, int stopR) {
        // Additional arrays needed for merging
        int[] right = new int[stopR - startR];
        int[] left = new int[stopL - startL];

        // Copy the elements to the additional arrays
        for(int i = 0, k = startR; i < (right.length); ) {
            right[i++] = array[k++];
        }
        for(int i = 0, k = startL; i < (left.length); ) {
            left[i++] = array[k++];
        }

        int leftArrLength = left.length;
        int rightArrLength = right.length;

        int i=0,j=0,k=startL;

        while(i < leftArrLength && j<rightArrLength){
            if(left[i]< right[j]){
                array[k++] = left[i++];
            }
            else {
                array[k++] = right[j++];
            }
        }

        while(i<leftArrLength){
            array[k++] = left[i++];
        }

        while(j<rightArrLength){
            array[k++] = right[j++];
        }

        System.out.println("The array sorted until now is : " + Arrays.stream(array).boxed().collect(Collectors.toList()));

    }

    public static void main(String[] args) {
        // Beacuse of the chosen Sentinel the array
        // should contain values smaller than Integer.MAX_VALUE .
        int[] array = new int[] {12, 11, 13, 5, 6, 7, 12, 11, 13, 5, 6, 7, 12, 11, 13, 5, 6, 7};
//        int[] array = new int[] {6,5,4,3,2,1,8,7};
        mergeSort(array);
        printArray(array);
    }
}