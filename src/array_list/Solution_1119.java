package array_list;

import java.util.Arrays;

public class Solution_1119 {
    // 137. Single Number II
    // Given an integer array nums where every element appears three times except for one, which appears exactly once.
    // Find the single element and return it.
    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // 1 <= nums.length <= 3 * 104
    // -231 <= nums[i] <= 231 - 1
    // Each element in nums appears exactly three times except for one element which appears once.
    public int Solution137(int[] nums) {
        Arrays.sort(nums);

        int beforeNum = Integer.MIN_VALUE, count = 0;

        for(int num : nums) {
            if(beforeNum != num) {
                if(count == 1) {
                    return beforeNum;
                }

                beforeNum = num;
                count = 1;
            } else {
                count ++;
            }
        }
        return beforeNum;
    }
}
