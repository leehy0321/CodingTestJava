package array_list;

public class Solution_0425 {
    // 238. Product of Array Except Self
    // Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    // You must write an algorithm that runs in O(n) time and without using the division operation.

    // Constraints:
    // 2 <= nums.length <= 105
    // -30 <= nums[i] <= 30
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    public int[] Solution238_1(int[] nums) {
        int[] results = new int[nums.length];

        int allMultipleValue = 1;

        for (int num : nums) {
            allMultipleValue *= num;
        }

        for (int i = 0; i < nums.length; i++) {
            results[i] = nums[i] == 0 ? 0 : (allMultipleValue / nums[i]);
        }

        return results;
    }

    public int[] Solution238_2(int[] nums) {
        int zeroIndex = -1; // 0's count == 1 -> index / 0's count > 1 -> -99 / 0's count == 0 -> -1

        int allMultipleValue = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = zeroIndex == -1 ? i : -99;
            } else {
                allMultipleValue *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroIndex == -99) {
                nums[i] = 0;
            } else if (zeroIndex == -1) {
                nums[i] = allMultipleValue / nums[i];
            } else {
                if (zeroIndex == i) {
                    nums[i] = allMultipleValue;
                } else {
                    nums[i] = 0;
                }
            }
        }

        return nums;
    }

    public int[] Solution238_3(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        // prefix
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // suffix
        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public int[] Solution238(int[] nums) {
        int[] result = new int[nums.length];

        // prefix
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // suffix & result
        int suffixMultiple = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffixMultiple;
            suffixMultiple *= nums[i];
        }

        return result;
    }


}
