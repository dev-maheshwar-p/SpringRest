package algorithms.search;

import java.util.Arrays;

public class MergeSortEasierImplementation {
    public static void main(String args[]){
//        int[] iArr = {1,5,4,6,9,3};

        int[] iArr = {5,2,4,1,3,6};

        mergeSort(iArr);

        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] iArr) {

        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;

        int i=0,j=0,k=0;

        while(i < leftArrLength && j<rightArrLength){
            if(leftArr[i]< rightArr[j]){
                iArr[k++] = leftArr[i++];
            }
            else {
                iArr[k++] = rightArr[j++];
            }
        }

        while(i<leftArrLength){
            iArr[k++] = leftArr[i++];
        }

        while(j<rightArrLength){
            iArr[k++] = rightArr[j++];
        }

        System.out.println();
    }

    private static void mergeSort(int[] iArr) {

        if(iArr.length<2) return;

        int left = 0;
        int right = iArr.length;
        int mid = ((left + right))/2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[right - mid];

        for (int i=0; i <mid; i++){
            leftArr[i] = iArr[i];
        }

        for (int i=mid; i <right; i++){
            rightArr[i-mid] = iArr[i];
        }


        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, iArr);


    }
}
