package algorithms.dynamicprogramming;

import java.util.Calendar;

public class Fibinocci {

    public static void main(String[] args) {

        Fibinocci f = new Fibinocci();

//        printTime();
//        System.out.println(f.calculateFibinocciRecursion(47));
//        printTime();

        printTime();
//        System.out.println(f.calculateFibinocciMemoized(120, new Long[120]));
        System.out.println(f.calculateFibinocciMemoized(5, new Long[5]));
        printTime();
    }

    private long calculateFibinocciMemoized(int n, Long[] memoizedArr) {

        if(null != memoizedArr[n-1]){
            return memoizedArr[n-1];
        }

        if(n==1 || n==2){
            return 1;
        }

        long result = calculateFibinocciMemoized(n-1, memoizedArr) + calculateFibinocciMemoized(n-2, memoizedArr);

        memoizedArr[n-1] = result;

        return result;
    }

    private static void printTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println(calendar.getTime());
    }

    private long calculateFibinocciRecursion(int i) {

        if(i==1 || i==2){
            return 1;
        }

        return calculateFibinocciRecursion(i-1) + calculateFibinocciRecursion(i-2);
    }


}
