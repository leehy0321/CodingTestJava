package array_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_0413 {

    public int Solution121_1(int[] prices) {
        int maxProfit = 0;
        int buyTime = 0, sellTime = prices.length - 1;

        while (sellTime > buyTime) {
            int currentProfit = prices[sellTime] - prices[buyTime];
            currentProfit = Math.max(currentProfit, 0);

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            // move
            int moveCase1 = prices[sellTime] - prices[buyTime + 1];
            int moveCase2 = prices[sellTime - 1] - prices[buyTime];

            if (moveCase1 >= moveCase2) {
                ++buyTime;
            } else {
                --sellTime;
            }
        }

        return maxProfit;
    }

    public int Solution121_2(int[] prices) {
        // Array copy
        int[] sortedPrices = new int[prices.length];
        System.arraycopy(prices, 0, sortedPrices, 0, prices.length);

        // sort
        Arrays.sort(sortedPrices);

        // check profit
        int leftIndex = 0, rightIndex = prices.length - 1;
        int buyTime = 0, sellTime = 0;
        while (leftIndex < rightIndex) {
            // find buyTime from prices.
            for (int i = 0; i < sortedPrices.length; i++) {
                if (prices[i] == sortedPrices[leftIndex]) {
                    buyTime = i;
                    break;
                }
            }

            for (int i = sortedPrices.length - 1; i >= 0; i--) {
                if (prices[i] == sortedPrices[rightIndex]) {
                    sellTime = i;
                    break;
                }
            }

            if (sellTime > buyTime) return prices[sellTime] - prices[buyTime];

            if (sortedPrices[rightIndex - 1] - sortedPrices[leftIndex]
                    > sortedPrices[rightIndex] - sortedPrices[leftIndex + 1]) {
                --rightIndex;
            } else {
                ++leftIndex;
            }
        }

        return 0;
    }

    public int Solution121_3(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int max = 0, currentProfit = 0;

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]
                        && prices[j] > max) {
                    max = prices[j];
                }
            }

            currentProfit = max - prices[i];
            if (maxProfit < currentProfit) {
                maxProfit = currentProfit;
            }
        }


        return maxProfit;
    }

    public int Solution121(int[] prices) {
        int maxProfit = 0;
        int buyTime = 0, sellTime = buyTime + 1;
        while (sellTime < prices.length) {
            if (prices[sellTime] < prices[buyTime]) {
                // set buyTime to sellTime.
                buyTime = sellTime;
            } else {
                // check current profit and maxProfit.
                int currentProfit = prices[sellTime] - prices[buyTime];
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }

            sellTime++;
        }

        return maxProfit;
    }

    public int Solution122(int[] prices) {
        int maxProfit = 0;

        int buyTime = 0, sellTime = 1;
        while (sellTime < prices.length) {
            if (prices[sellTime] < prices[buyTime]) {
                buyTime = sellTime;
                sellTime++;
            } else {
                if (sellTime < prices.length - 1 && prices[sellTime] > prices[sellTime + 1]) {
                    maxProfit += (prices[sellTime] - prices[buyTime]);
                    buyTime = sellTime;
                    sellTime = buyTime + 1;
                } else if (sellTime >= prices.length - 1) {
                    maxProfit += prices[sellTime] - prices[buyTime];
                    sellTime++;
                } else {
                    sellTime++;
                }
            }
        }

        return maxProfit;
    }
}
