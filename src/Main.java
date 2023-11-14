import array_list.Solution_1108;
import array_list.Solution_1109;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Solution_1109 solution = new Solution_1109();

        // 9,9
        Solution_1109.ListNode l1 = new Solution_1109.ListNode(9, new Solution_1109.ListNode(9));
        //9,9,9,9
        Solution_1109.ListNode l2 = new Solution_1109.ListNode(9, new Solution_1109.ListNode(9, new Solution_1109.ListNode(9, new Solution_1109.ListNode(9))));

        Solution_1109.ListNode a = solution.Solution2(l1,l2);
    }
}