package stack;

import java.util.Stack;

public class Solution_0105 {
    // 20. Valid Parentheses
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    // An input string is valid if:
    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.
    // Every close bracket has a corresponding open bracket of the same type.

    // 1 <= s.length <= 104
    // s consists of parentheses only '()[]{}'.
    public boolean solution20(String s) {
        char[] inputCharArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : inputCharArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (checkCouple(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    // c1 : stack(saved) char
    // c2 : new char
    private boolean checkCouple(char c1, char c2) {
        char[] savedConsistsArray1st = {'(', '[', '{'};
        char[] savedConsistsArray2nd = {')', ']', '}'};

        for (int i = 0; i < savedConsistsArray1st.length; i++) {
            if (savedConsistsArray1st[i] == c1) {
                return savedConsistsArray2nd[i] == c2;
            }
        }

        return false;
    }

    // 1003. Check If Word Is Valid After Substitutions
    // Given a string s, determine if it is valid.
    //
    // A string s is valid if,
    // starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:
    // Insert string "abc" into any position in t.
    // More formally, t becomes tleft + "abc" + tright,
    // where t == tleft + tright. Note that tleft and tright may be empty.
    // Return true if s is a valid string, otherwise, return false.

    // 1 <= s.length <= 2 * 104
    // s consists of letters 'a', 'b', and 'c'
    public boolean solution1003(String s) {
        char[] input = s.toCharArray();
        Stack<Character> savedInput = new Stack<>();

        for(int i = input.length - 1; i >= 0; i--) {
            if(input[i] == 'a' && savedInput.size() >= 2) {
                if(savedInput.pop() != 'b' || savedInput.pop() != 'c') {
                    return false;
                }
            } else {
                savedInput.push(input[i]);
            }
        }
        return savedInput.isEmpty();
    }
}
