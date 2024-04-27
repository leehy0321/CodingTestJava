package array_list;

public class Solution_0426 {
    // 152. Maximum Product Subarray
    // Given an integer array nums, find a subarray
    // that has the largest product, and return the product.
    //
    // The test cases are generated so that the answer will fit in a 32-bit integer.

    // Constraints:
    //
    // 1 <= nums.length <= 2 * 104
    // -10 <= nums[i] <= 10
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    public int Solution152_1(int[] nums) {
        int maximumNum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currentMultiple = nums[i];
            if (maximumNum < currentMultiple) maximumNum = currentMultiple;

            for (int j = i + 1; j < nums.length; j++) {
                currentMultiple *= nums[j];
                if (maximumNum < currentMultiple) maximumNum = currentMultiple;
            }
        }
        return maximumNum;
    }

    public int Solution152(int[] nums) {
        int rightIndex = nums.length - 1;
        int leftValue = nums[0], rightValue = nums[rightIndex];
        int maximumNum = Math.max(leftValue, rightValue);

        for (int i = 1; i < nums.length; i++) {
            // zero case
            rightValue = rightValue == 0 ? 1 : rightValue;
            leftValue = leftValue == 0 ? 1 : leftValue;

            // left
            leftValue *= nums[i];

            // right
            rightValue *= nums[rightIndex - i];

            // maximum
            maximumNum = Math.max(maximumNum, Math.max(leftValue, rightValue));
        }

        return maximumNum;
    }

    // 1641. Count Sorted Vowel Strings
    // Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u)
    // and are lexicographically sorted.
    //
    // A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
    // Constraints:
    //
    // 1 <= n <= 50
    public int Solution1641(int n) {
        int[] Aeiou = {1,1,1,1,1};
        for(int i=0; i<n; i++) {
            Aeiou[0] = Aeiou[0] + Aeiou[1]+ Aeiou[2]+ Aeiou[3]+ Aeiou[4];
            Aeiou[1] = Aeiou[1] + Aeiou[2]+ Aeiou[3]+ Aeiou[4];
            Aeiou[2] = Aeiou[2] + Aeiou[3]+ Aeiou[4];
            Aeiou[3] = Aeiou[3] + Aeiou[4];
        }

        return Aeiou[0];
    }
}
