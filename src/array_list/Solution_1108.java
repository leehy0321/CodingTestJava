package array_list;
public class Solution_1108 {
    // 1920. Build Array from Permutation
    // Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
    // A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
    public int[] Solution1920(int[] nums) {
        int[] answer = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
           answer[i] = nums[nums[i]];
        }

        return answer;
    }

    // 26. Remove Duplicates from Sorted Array
    // Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    // Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    // Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    // Return k.
    // 1 <= nums.length <= 3 * 104
    public int Solution26(int[] nums) {
        int prevIndex = 0, prevNumsMember = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(prevNumsMember != nums[i]) {
                prevNumsMember = nums[i];
                nums[++prevIndex] = nums[i];
            }
        }

        return prevIndex+1;
    }

    // 11. Container With Most Water
    // You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    // Find two lines that together with the x-axis form a container, such that the container contains the most water.
    // Return the maximum amount of water a container can store.
    // Notice that you may not slant the container.
    // n == height.length
    // 2 <= n <= 105
    // 0 <= height[i] <= 104
    public int Solution11(int[] height) {
        int maxArea = 0, currentArea = 0;
        int leftIndex = 0, rightIndex = height.length - 1;

        while(leftIndex != rightIndex) {
            currentArea = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);

            if(height[leftIndex] < height[rightIndex]) {
                ++leftIndex;
            } else {
                --rightIndex;
            }

            if(currentArea > maxArea) {
                maxArea = currentArea;
            }
        }

        return maxArea;

        // try 2. Wrong Answer
        /* int maxArea = 0, currentArea = 0, leftMovedArea = 0, rightMovedArea = 0;
        int leftIndex = 0, rightIndex = height.length - 1;
        while(leftIndex != rightIndex) {
            currentArea = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);

            leftMovedArea = (rightIndex - (leftIndex+1) ) * Math.min(height[leftIndex + 1], height[rightIndex]);
            rightMovedArea = ((rightIndex-1) - leftIndex) * Math.min(height[leftIndex], height[rightIndex-1]);

            if(leftMovedArea > rightMovedArea) {
                ++leftIndex;
            } else {
                --rightIndex;
            }

            if(currentArea > maxArea) {
                maxArea = currentArea;
            }
        }

        return maxArea; */

        // try1. Time Limit Exceeded
        /* int maxArea = 0, currentArea = 0;
        for(int i =0; i<height.length; i++) {
            for(int j=height.length - 1; j >= i; j--) {
                currentArea = (j-i) * Math.min(height[i], height[j]);

                if(maxArea < currentArea) {
                    maxArea = currentArea;
                }
            }
        }

        return maxArea; */

    }
}
