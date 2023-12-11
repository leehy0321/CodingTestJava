package stack;

import java.util.Stack;

public class Solution_1210 {
    // 682. Baseball Game
    // You are keeping the scores for a baseball game with strange rules.
    // At the beginning of the game, you start with an empty record.
    //You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
    //
    //An integer x.
    //Record a new score of x.
    //'+' : Record a new score that is the sum of the previous two scores.
    //'D' : Record a new score that is the double of the previous score.
    //'C' : Invalidate the previous score, removing it from the record.
    //Return the sum of all the scores on the record after applying all the operations.
    //The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

    // Constraints:
    //1 <= operations.length <= 1000
    //operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
    //For operation "+", there will always be at least two previous scores on the record.
    //For operations "C" and "D", there will always be at least one previous score on the record.
    public int solution682(String[] operations) {
        int finalValue = 0;
        int latestNum1 = 0, latestNum2 = 0;
        Stack<Integer> stack = new Stack<>();

        for(String operation : operations) {
            switch (operation) {
                case "+" :
                    latestNum1 = stack.peek();
                    latestNum2 = stack.get(stack.size() - 2);
                    stack.push(latestNum1 + latestNum2);

                    finalValue += latestNum1 + latestNum2;
                break;
                case "D" :
                    latestNum1 = stack.peek();
                    stack.push(latestNum1 * 2);
                    finalValue += latestNum1 * 2;
                break;
                case "C" :
                    latestNum1 = stack.pop();
                    finalValue -= latestNum1;
                break;
                default :
                    stack.push(Integer.parseInt(operation));
                    finalValue += Integer.parseInt(operation);
                break;
            }
        }

        return finalValue;
    }
}
