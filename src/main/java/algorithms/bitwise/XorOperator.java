package algorithms.bitwise;

public class XorOperator {

    public static void main(String[] args) {

        int[] iArr = new int[]{10,5,10};

        int result=0;

        for (int i = 0; i < iArr.length; i++) {
            result ^= iArr[i];

            if(result==0){
                System.out.println("There are duplicates in the array");
            }
        }

        System.out.println(result);
    }
}
