package array_list;

public class Solution_1109 {

    // 2. Add Two Numbers
    // You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    // Definition for singly-linked list.

    // The number of nodes in each linked list is in the range [1, 100].
    // 0 <= Node.val <= 9
    // It is guaranteed that the list represents a number that does not have leading zeros.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode Solution2(ListNode l1, ListNode l2) {
        // try 1. long range over (max is 10^15 but this problem needs max 10^99)
        /*
        long sumListNumber = 0, position = 1;

        sumListNumber += l1.val;
        while (l1.next != null) {
            l1 = l1.next;
            position *= 10;
            sumListNumber += (l1.val * position);
        }

        sumListNumber += l2.val;
        position = 1;
        while (l2.next != null) {
            l2 = l2.next;
            position *= 10;
            sumListNumber += (l2.val * position);
        }

        int newNodeValue = (int) (sumListNumber % 10);
        ListNode result = new ListNode(newNodeValue);
        sumListNumber /= 10;

        ListNode current, newNode;
        current = result;
        while (sumListNumber > 0) {
            newNodeValue = (int) (sumListNumber % 10);
            newNode = new ListNode(newNodeValue);
            current.next = newNode;
            current = newNode;
            sumListNumber /= 10;
        }

        return result;
         */

        ListNode result = new ListNode();
        ListNode current = result, newNode;
        int sum = 0;
        boolean isNeedPlusOne = false, isInit = true;

        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if(isNeedPlusOne) {
                ++sum;
            }

            if(isInit) {
                result = new ListNode(sum % 10);
                current = result;
                isInit = false;
            } else {
                newNode = new ListNode(sum % 10);
                current.next = newNode;
                current = newNode;
            }

            isNeedPlusOne = sum >= 10;
            sum = 0;
        }

        if(isNeedPlusOne) {
            newNode = new ListNode(1);
            current.next = newNode;
        }

        return result;
    }
}
