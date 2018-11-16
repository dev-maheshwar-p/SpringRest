package algorithms.arrays;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class MaximizeProfitBuyAndSell {
    public static void main(String[] args) {
         MaximizeProfitBuyAndSell mpbs = new MaximizeProfitBuyAndSell();
         int[] iArr = new int[]{7,4,5,8,11,4,5};

        System.out.println(mpbs.maxProfit(iArr));
        System.out.println(mpbs.calculateMaxProfit(iArr));
        System.out.println(mpbs.maxProfitPointerSolution(iArr));
    }


    /*
        This is my code.
     */
    public int calculateMaxProfit(int[] prices){

        int totalProfit = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1]>prices[i]){
                totalProfit += prices[i+1] - prices[i];
            }
        }

        return totalProfit;
    }


    /*

    for i = 0 to prices.length -1
    1. if prices[i] > prices[i+1] set minPointer = i+1.
    2. if i > minPointer then maxP += prices[i] - prices[minPointer]
     */

    public int maxProfitPointerSolution(int[] prices) {

        int currentMinPointer = 0;
        int maxP = 0;
        boolean pointerChangedFlag = true;

        for(int i=0;i<prices.length-1;i++){

            if(prices[i]>prices[i+1]){
                pointerChangedFlag = true;
                currentMinPointer = i+1;
            }else{

                maxP += prices[i+1] - prices[currentMinPointer];

                if(pointerChangedFlag == false){
                    maxP -= prices[i]-prices[currentMinPointer];
                }
                pointerChangedFlag = false;
            }
        }

        return maxP;
    }


    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int maxP = 0;
        int maxDiff = 0;

        for(int i=1;i<prices.length;i++){

            int diff = prices[i]-min;
            // diff > maxDiff for ascending seq like 1, 5, 8
            if(maxDiff < diff){
                maxP += (diff-maxDiff);
                // 1, 5, 8 first 5-1 = 4 is added,
                //then 8-1=7 is added and 4 the prev max diff is subtracted.
                maxDiff = diff;
            }else{
                /* 1, 5, 8, 6 then 6-1=5 is less than 8-1 = 7, at this point buy again at 6. when diff < maxDiff, it means sell the stock nd buy again. */
                min = prices[i];
                maxDiff = 0; // buying again.
            }
        }
        return maxP;
    }
}
