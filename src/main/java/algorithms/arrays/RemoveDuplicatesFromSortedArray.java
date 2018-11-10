package algorithms.arrays;


/*

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


 */


public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {

        int nums[] = new int[]{1,1,1,2,2,2,2,2,2,2,2,2,3,4,6,6,6,9,9,9,10,10,11};

        RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
//        int uniqueItems = rdfsa.removeDuplicatesRefactored(nums);
        int uniqueItems = rdfsa.removeDuplicates2(nums);

        System.out.println("There are " + uniqueItems + " unique numbers in the array \n");
        printUniqueItemsInArray(nums,uniqueItems);

    }

    private static void printUniqueItemsInArray(int[] nums, int uniqueItems) {

        System.out.println("The " + uniqueItems + " unique numbers in the array are :");

        for (int i = 0; i < uniqueItems; i++) {
            System.out.println(nums[i]);
        }

    }


    public int removeDuplicates(int[] nums) {

        int lengthOfArray = nums.length;
        int totalDuplicates = 0;
        int properPosition = 1;

        for(int i=0; i<lengthOfArray; i++){

            int chain = 0;
            int index = i;

            while(index+1 < lengthOfArray && nums[index]==nums[++index]){
                chain++;
            }

            i = i+chain;
            totalDuplicates+=chain;

            if((i+1)<lengthOfArray){
                nums[properPosition++] = nums[i+1];
            }

        }

        return lengthOfArray - totalDuplicates;
    }


    public int removeDuplicatesRefactored(int[] nums) {

        int uniqueElementsCount = 0;

        for(int boundryIndex=1; boundryIndex<nums.length; boundryIndex++){

            if(nums[boundryIndex]!=nums[uniqueElementsCount]){
                uniqueElementsCount++;
                nums[uniqueElementsCount] = nums[boundryIndex];
            }
        }

        return uniqueElementsCount+1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
