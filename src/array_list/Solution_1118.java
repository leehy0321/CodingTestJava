package array_list;

import java.util.*;

public class Solution_1118 {
    // 5. Longest Palindromic Substring
    // Given a string s, return the longest palindromic substring in s.
    // 1 <= s.length <= 1000
    // s consist of only digits and English letters.
    public String Solution5(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int leftIndex, rightIndex;
        String currentPalindromic = "";
        String longestPalindromic = "";

        for (int i = 1; i < s.length(); i++) {
            // 1. palindromic is odd length
            leftIndex = i;
            rightIndex = i;

            while (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex--;
                rightIndex++;

                if (leftIndex < 0 || rightIndex >= s.length()) {
                    break;
                }
            }

            currentPalindromic = s.substring(leftIndex + 1, rightIndex);

            if (currentPalindromic.length() > longestPalindromic.length()) {
                longestPalindromic = currentPalindromic;
            }

            // 2. palindromic is even length
            leftIndex = i - 1;
            rightIndex = i;
            while (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex--;
                rightIndex++;

                if (leftIndex < 0 || rightIndex >= s.length()) {
                    break;
                }
            }

            currentPalindromic = s.substring(leftIndex + 1, rightIndex);

            if (currentPalindromic.length() > longestPalindromic.length()) {
                longestPalindromic = currentPalindromic;
            }
        }
        return longestPalindromic;
    }

    // 18. 4Sum
    // Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
    // 0 <= a, b, c, d < n
    // a, b, c, and d are distinct.
    // nums[a] + nums[b] + nums[c] + nums[d] == target
    // You may return the answer in any order.
    // 1 <= nums.length <= 200
    // -109 <= nums[i] <= 109
    // -109 <= target <= 109
    public List<List<Integer>> Solution18(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        // 1. sort
        Arrays.sort(nums);

        // 2. set base1(i), base2(j), left, right
        int leftIndex, rightIndex;
        long sum4; // *** POINT!! long
        List<Integer> currentIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                leftIndex = j + 1;
                rightIndex = nums.length - 1;

                while (leftIndex < rightIndex) {
                    sum4 = (long) nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex]; // *** POINT!! long

                    if (sum4 == target) {
                        currentIndexes = new ArrayList<>();

                        currentIndexes.add(nums[i]);
                        currentIndexes.add(nums[j]);
                        currentIndexes.add(nums[leftIndex]);
                        currentIndexes.add(nums[rightIndex]);

                        result.add(currentIndexes);

                        leftIndex++;
                        rightIndex--;
                    } else if (sum4 < target) { // left ++
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    // 347. Top K Frequent Elements
    // Given an integer array nums and an integer k, return the k most frequent elements.
    // You may return the answer in any order.
    // 1 <= nums.length <= 105
    // -104 <= nums[i] <= 104
    // k is in the range [1, the number of unique elements in the array].
    // It is guaranteed that the answer is unique.
    public int[] Solution347(int[] nums, int k) {
        // WAY 1 : My way
        /*
        // 1. sort
        Arrays.sort(nums);

        List<Integer> savedCountList = new ArrayList<>();
        List<Integer> savedNumberList = new ArrayList<>();
        // 2.
        int count = 1, beforeNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == beforeNum) {
                count++;
            } else {
                boolean isSaved = false;
                int targetIndex = 0;
                for (int j = 0; j < Math.min(savedCountList.size(), k); j++) {
                    if (count > savedCountList.get(j)) {
                        savedCountList.add(j, count);
                        savedNumberList.add(j, beforeNum);

                        isSaved = true;
                        break;
                    }
                }

                if (!isSaved) {
                    savedCountList.add(count);
                    savedNumberList.add(beforeNum);
                }

                beforeNum = nums[i];
                count = 1;
            }
        }

        if (savedNumberList.size() < k) {
            savedCountList.add(count);
            savedNumberList.add(beforeNum);
        } else {
            for (int j = 0; j < Math.min(savedCountList.size(), k); j++) {
                if (count > savedCountList.get(j)) {
                    savedCountList.add(j, count);
                    savedNumberList.add(j, beforeNum);

                    break;
                }
            }
        }

        return savedNumberList.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
         */

        // WAY 2 : Efficiency way
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int number : nums) {
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
        }

        List<Integer> savedCountList = new ArrayList<>();
        List<Integer> savedNumberList = new ArrayList<>();

        for (int key : freqMap.keySet()) {
            int compareSize = Math.min(k, savedCountList.size());

            int currentCount = freqMap.get(key);
            int targetIndex = 0;
            for (int i = 0; i < compareSize; i++) {
                if (currentCount > savedCountList.get(i)) {
                    targetIndex = i;
                    break;
                } else {
                    targetIndex = savedCountList.size();
                }
            }

            savedCountList.add(targetIndex, currentCount);
            savedNumberList.add(targetIndex, key);
        }

        return savedNumberList.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
    }
}
