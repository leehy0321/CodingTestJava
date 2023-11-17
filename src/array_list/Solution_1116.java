package array_list;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_1116 {

    // 16. 3Sum Closest
    // Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    // Return the sum of the three integers.
    // You may assume that each input would have exactly one solution.
    // 3 <= nums.length <= 500
    // -1000 <= nums[i] <= 1000
    // -104 <= target <= 104
    public int Solution16(int[] nums, int target) {
        // 1. sort
        Arrays.sort(nums);

        // 2.set base, left, right
        int leftIndex, rightIndex, currentSum, closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            leftIndex = i + 1;
            rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                currentSum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if (Math.abs(closestSum - target) > Math.abs(currentSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum == target) {
                    return currentSum;
                } else if (currentSum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return closestSum;
    }

    // 3. Longest Substring Without Repeating Characters
    // Given a string s, find the length of the longest substring without repeating characters.
    // 0 <= s.length <= 5 * 104
    // s consists of English letters, digits, symbols and spaces.
    public int Solution3(String s) {
        int[] inputArray = s.chars().toArray();

        int longestLength = 0;
        HashSet<Integer> savedHash = new HashSet<>();
        for (int i = 0; i < inputArray.length; i++) {
            // check duplicate
            savedHash.add(inputArray[i]);
            for (int j = i + 1; j < inputArray.length; j++) {
                if (!savedHash.add(inputArray[j])) {
                    break;
                }
            }

            if (savedHash.size() > longestLength) {
                longestLength = savedHash.size();
            }

            // init values
            savedHash.clear();
        }
        return longestLength;
    }
}
