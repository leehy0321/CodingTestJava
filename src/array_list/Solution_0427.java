package array_list;

import java.util.Arrays;

public class Solution_0427 {
    // 2932. Maximum Strong Pair XOR I
    public int Solution2932_1(int[] nums) {
        int maximum = 0, XORValue = 0;

        Arrays.sort(nums);

        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            int rightIndex = leftIndex;

            while (rightIndex < nums.length &&
                    nums[rightIndex] - nums[leftIndex] <= nums[leftIndex]) {
                XORValue = nums[rightIndex] ^ nums[leftIndex];
                maximum = Math.max(XORValue, maximum);
                rightIndex++;
            }
        }

        return maximum;
    }

    public int Solution2932_2(int[] nums) {
        int maximum = 0;

        for (int leftNumber : nums) {
            for (int rightNumber : nums) {
                if ((leftNumber ^ rightNumber) > maximum
                        && Math.abs(leftNumber - rightNumber) <= Math.min(leftNumber, rightNumber)) {
                    maximum = leftNumber ^ rightNumber;
                }
            }
        }
        return maximum;
    }

    public int Solution2932(int[] nums) {
        int maximum = 0, XORValue = 0;

        Arrays.sort(nums);

        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            for (int rightIndex = leftIndex; rightIndex < nums.length; rightIndex++) {
                XORValue = nums[rightIndex] ^ nums[leftIndex];
                if(XORValue > maximum
                        && nums[rightIndex] - nums[leftIndex] <= nums[leftIndex]) {
                    maximum = XORValue;
                } else if(nums[rightIndex] - nums[leftIndex] > nums[leftIndex]) {
                    break;
                }
            }
        }

        return maximum;
    }
}
