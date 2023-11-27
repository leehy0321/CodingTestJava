package random;

public class Solution_1126 {
    // 38. Count and Say
    // The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
    //
    // countAndSay(1) = "1"
    // countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
    // To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
    // Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
    // For example, the saying and conversion for digit string "3322251":
    // 1 <= n <= 30
    public String Solution38(int n) {
        String currentString;
        StringBuilder result = new StringBuilder("1");

        char beforeChar;
        int sameCount;
        while(--n > 0) {
            currentString = result.toString();
            result = new StringBuilder();
            beforeChar = '.';
            sameCount = 1;
            for(char currentChar : currentString.toCharArray()) {
                if(beforeChar == '.') {
                    beforeChar = currentChar;
                } else if(beforeChar == currentChar) {
                    sameCount++;
                } else {
                    result.append(sameCount).append(beforeChar);
                    beforeChar = currentChar;
                    sameCount = 1;
                }
            }

            result.append(sameCount).append(beforeChar);
        }
        return result.toString();
    }

    // 80. Remove Duplicates from Sorted Array II
    // Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
    // The relative order of the elements should be kept the same.
    // Since it is impossible to change the length of the array in some languages,
    // you must instead have the result be placed in the first part of the array nums. More formally,
    // if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
    // It does not matter what you leave beyond the first k elements.
    // Return k after placing the final result in the first k slots of nums.
    // Do not allocate extra space for another array.
    // You must do this by modifying the input array in-place with O(1) extra memory.

    // 1 <= nums.length <= 3 * 104
    // -104 <= nums[i] <= 104
    public int Solution80(int[] nums) {
        int count = 1;

        int beforeNum = nums[0];
        int sameCount = 0;
        for(int i=1; i<nums.length; i++) {
            if(beforeNum == nums[i]) {
                if(sameCount < 1) {
                    nums[count] = nums[i];
                    sameCount++;
                    count++;
                }
            } else {
                nums[count] = nums[i];
                beforeNum = nums[i];
                sameCount = 0;
                count++;
            }
        }

        return count;
    }

}
