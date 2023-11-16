package array_list;

import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import java.sql.Array;
import java.util.*;

public class Solution_1115 {
    // 4. Median of Two Sorted Arrays
    // Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    // The overall run time complexity should be O(log (m+n)).

    // nums1.length == m
    // nums2.length == n
    // 0 <= m <= 1000
    // 0 <= n <= 1000
    // 1 <= m + n <= 2000
    // -106 <= nums1[i], nums2[i] <= 106
    public double Solution4(int[] nums1, int[] nums2) {
        int sumLength = nums1.length + nums2.length;
        int[] allArray = new int[sumLength];

        System.arraycopy(nums1, 0, allArray, 0, nums1.length);
        System.arraycopy(nums2, 0, allArray, nums1.length, nums2.length);

        Arrays.sort(allArray);

        if (sumLength % 2 > 0) {
            return (double) allArray[sumLength / 2];
        } else {
            return (double) (allArray[sumLength / 2] + allArray[sumLength / 2 - 1]) / 2;
        }
    }

    // 27. Remove Element
    // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    // The order of the elements may be changed.
    // Then return the number of elements in nums which are not equal to val.
    // Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
    // Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    // The remaining elements of nums are not important as well as the size of nums.
    // Return k.
    // 0 <= nums.length <= 100
    // 0 <= nums[i] <= 50
    // 0 <= val <= 100
    public int Solution27(int[] nums, int val) {
        int[] copyNums = new int[nums.length];
        int copyNumsIndex = 0;

        for (int num : nums) {
            if (num != val) {
                copyNums[copyNumsIndex] = num;
                copyNumsIndex++;
            }
        }

        System.arraycopy(copyNums, 0, nums, 0, nums.length);
        return copyNumsIndex;
    }

    // 15. 3Sum
    // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    // Notice that the solution set must not contain duplicate triplets.
    // 3 <= nums.length <= 3000
    // -105 <= nums[i] <= 105
    public List<List<Integer>> Solution15(int[] nums) {
        // TRY 1. Time limit!
        /*
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> listContent;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] + nums[j]+ nums[k] == 0) {
                        listContent  = new ArrayList<Integer>();

                        listContent.add(nums[i]);
                        listContent.add(nums[j]);
                        listContent.add(nums[k]);

                        Collections.sort(listContent);

                        if(!resultList.contains(listContent)) {
                            resultList.add(listContent);
                        }
                    }
                }
            }
        }

        return resultList;
        */

        // TRY2. Time Limit Exceeded
        // 312 / 312 testcases passed
        // Testcases passed, but took too long.
        /*
        // 1. Sort
        Arrays.sort(nums);

        // 2. find
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> listContent;

        int letfIndex, rightIndex;
        for(int i=0; i<nums.length - 2; i++) {
            letfIndex = i + 1;
            rightIndex = nums.length - 1;

            while(letfIndex != rightIndex) {
                if(nums[i] + nums[letfIndex] + nums[rightIndex] == 0) {
                    listContent = new ArrayList<Integer>();
                    listContent.add(nums[i]);
                    listContent.add(nums[letfIndex]);
                    listContent.add(nums[rightIndex]);

                    if(!resultList.contains(listContent)) {
                        resultList.add(listContent);
                    }

                    rightIndex--;
                } else if(nums[i] + nums[letfIndex] + nums[rightIndex] > 0) {
                    rightIndex--;
                } else if(nums[i] + nums[letfIndex] + nums[rightIndex] < 0) {
                    letfIndex++;
                }
            }
        }

        return resultList;
         */

        // TRY3.
        // - Point :
        //   1. HashSet. (disable to duplicate elements, don't need to check contains -> it needs more time)
        //   2. Both side (leftIndex, rightIndex) have to move after saved.
        //   3. While condition is leftIndex is lower than rightIndex.
        // - Ways :
        //   1. sort input array.
        //   2. set base.
        //   3. compare remains nums using leftIndex and rightIndex.

        // way-1. sort inut array
        Arrays.sort(nums);

        Set<List<Integer>> resultList = new HashSet<>();
        List<Integer> listContent;
        int letfIndex, rightIndex;

        // way-2. set base (=i)
        for (int i = 0; i < nums.length - 2; i++) {
            letfIndex = i + 1;
            rightIndex = nums.length - 1;

            // way-3. compare remains nums using leftIndex and rightIndex.
            while (letfIndex < rightIndex) {
                int current3Sum = nums[i] + nums[letfIndex] + nums[rightIndex];
                if (current3Sum == 0) {
                    listContent = new ArrayList<Integer>();
                    listContent.add(nums[i]);
                    listContent.add(nums[letfIndex]);
                    listContent.add(nums[rightIndex]);

                    resultList.add(listContent);

                    rightIndex--;
                    letfIndex++;
                } else if (current3Sum > 0) {
                    rightIndex--;
                } else {
                    letfIndex++;
                }
            }
        }

        return new ArrayList<>(resultList);
    }

    // 1. Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    //  2 <= nums.length <= 104
    // -109 <= nums[i] <= 109
    // -109 <= target <= 109

    public int[] solution1(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int[] copyNums = new int[nums.length];

        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        Arrays.sort(copyNums);

        while(leftIndex < rightIndex) {
            int twoSum = copyNums[leftIndex] + copyNums[rightIndex];
            if(twoSum == target) {
                for(int i=0; i<nums.length; i++) {
                    if(nums[i] == copyNums[leftIndex]) {
                        leftIndex = i;
                        break;
                    }
                }

                for(int i=0; i<nums.length; i++) {
                    if(nums[i] == copyNums[rightIndex] && leftIndex != i) {
                        rightIndex = i;
                        break;
                    }
                }

                return new int[] {leftIndex, rightIndex};
            } else if(twoSum > target) { // moving right
                rightIndex--;
            } else { // moving left
                leftIndex++;
            }
        }

        return null;
    }
}
