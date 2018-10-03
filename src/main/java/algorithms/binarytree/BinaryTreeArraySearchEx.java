package algorithms.binarytree;

public class BinaryTreeArraySearchEx {
    public static void main(String[] args) {
        System.out.println(findElement(12, new int[]{1,10,12,15}));

    }


    public static int findElement(int num, int[] iArr){

        int left = 0;
        int right  = iArr.length; //10
        int mid = (left + right)/2;//5

        int count = 0;

        while(mid !=0 && mid < iArr.length){

            mid = (left + right)/2;//5

            if(num < iArr[mid]){
                right = mid;
            }else if(num > iArr[mid]){
                left = mid;
            }else if(num == iArr[mid]){
                return mid;
            }
        }

        return -1;
    }
}
