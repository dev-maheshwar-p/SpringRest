package algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] intArr = {5,1,4,2,3,6};
        ArrayList<Integer> iArr = new ArrayList<>();

        iArr.addAll(Arrays.asList(intArr));

        for (int i = 1; i < intArr.length; i++) {

            int key = intArr[i];
            int j = i-1;

            while(j >= 0 && intArr[j] > key){
                intArr[j+1] = intArr[j--];
            }

            intArr[++j] = key;

            iArr = new ArrayList<>();
            iArr.addAll(Arrays.asList(intArr));

            System.out.println(iArr);
        }
        System.out.println(iArr);
    }


}
