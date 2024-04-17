package array_list;

public class Solution_0416 {
    public int Solution123(int[] prices) {
        int maxProfit = 0;

        // 1. 1st transaction from left to right - find min.
        int[] left = new int[prices.length];
        int min = prices[0];

        left[0] = 0; // for memorization to remember maximum profit of 1st transaction.

        for(int i=1; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min );
        }

        // 2. 2nd transaction from right to left - find max.
        int[] right = new int[prices.length];
        int max = prices[prices.length-1];

        right[prices.length-1] = 0; // for memorization to remember maximum profit of 2nd transaction.

        for(int i=prices.length-2; i>=0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max - prices[i]);
        }

        // 3. find maxProfit
        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}
