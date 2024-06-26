package bst;


public class Solution_0409 {
    // 98. Validate Binary Search Tree
    /* Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1
    */
    public boolean Solution98(TreeNode root) {
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValid(TreeNode node, long min, long max) {
        if(node == null) return true;

        if(node.val <= min || node.val >= max) {
            return false;
        }

        return checkValid(node.left, min, node.val)
                && checkValid(node.right, node.val, max);
    }
}
