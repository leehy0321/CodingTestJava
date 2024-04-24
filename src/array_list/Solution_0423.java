package array_list;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_0423 {
    // 217. Contains Duplicate
    // Given an integer array nums,
    // return true if any value appears at least twice in the array, and return false if every element is distinct.
    // Constraints:
    // 1 <= nums.length <= 105
    // -109 <= nums[i] <= 109
    public boolean Solution217_1(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for(int num : nums) {
            if(hash.contains(num)) return true;
            hash.add(num);
        }

        return false;
    }
    public boolean Solution217_2(int[] nums) {
        int length = nums.length;

        if(length == 1) return false;

        for(int i=1; i<length; i++) {
            int currentValue = nums[i];
            int j=i-1, beforeValue = nums[j];
            boolean changed = false;

            // insertion sort
            while(beforeValue > currentValue) {
                changed = true;
                nums[j+1] = beforeValue;

                if(j-- == 0) break;

                beforeValue = nums[j];
            }

            // set current value position.
            if(changed) nums[j+1] = currentValue;

            // check duplicate
            if(currentValue == beforeValue) return true;
        }
        return false;
    }

    // 219. Contains Duplicate II
    // Given an integer array nums and an integer k,
    // return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
    // Constraints:
    // 1 <= nums.length <= 105
    // -109 <= nums[i] <= 109
    // 0 <= k <= 105
    public boolean Solution219(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) return true;
            else map.put(nums[i], i);

        }

        return false;
    }
}
