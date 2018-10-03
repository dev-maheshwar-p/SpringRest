package algorithms.search;/* Iterative Java program for merge sort */

import java.util.Arrays;
import java.util.List;

public class TestAreaSorting {

    static void insertionSort(Integer[] iArr, Integer n) {

        for(Integer i=1; i<n; i++){

            Integer key = iArr[i];
            Integer j = i-1;

            while(j >= 0 && iArr[j]>key){
                iArr[j+1] = iArr[j];
                j--;
            }
            j++;
            iArr[j] = key;
        }

        List<Integer> arrList = Arrays.asList(iArr);

        System.out.println(arrList);
    }


    static void mergeSort(Integer[] iArr, Integer n) {
       mergeSort(iArr);
    }

    private static void mergeSort(Integer[] iArr) {

        if(iArr.length<=2) return;

        Integer left = 0;
        Integer right = iArr.length;
        Integer mid = (left+right)/2;

        Integer leftArr[] = new Integer[mid+1];
        Integer rightArr[] = new Integer[right-(mid+1)];

        for (Integer i=0; i<=mid; i++){
            leftArr[i] = iArr[i];
        }

        for (Integer j=mid+1; j<right; j++){
            rightArr[j-(mid+1)] = iArr[j];
        }

        List<Integer> leftList = Arrays.asList(leftArr);
        List<Integer> rightList = Arrays.asList(rightArr);

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr,rightArr, iArr);
    }

    private static void merge(Integer[] leftArr, Integer[] rightArr, Integer[] iArr) {

        int i=0,j=0,k=0;

        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;

        while(i < leftArrLength && j < rightArrLength){

            if(leftArr[i] < rightArr[j]){
                iArr[k++] = leftArr[i++];
            }else{
                iArr[k++] = rightArr[j++];
            }
        }

        while(i < leftArrLength){
            iArr[k++] = leftArr[i++];
        }

        while(j < rightArrLength){
            iArr[k++] = rightArr[j++];
        }

    }


    /* Driver program to test above functions */
    public static void main(String[] args) {
        Integer arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

//        insertionSort(arr, n);
//        mergeSort(arr, n);

        int[] iarr = new int[-1];

        System.out.println(Arrays.asList(arr));
    }
}