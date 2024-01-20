package dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution_0119 {
    // 94. Binary Tree Inorder Traversal
    // Given the root of a binary tree, return the inorder traversal of its nodes' values.
    // The number of nodes in the tree is in the range [0, 100].
    // -100 <= Node.val <= 100
    // Follow up: Recursive solution is trivial, could you do it iteratively?
    List<Integer> result = new ArrayList<>();

    public List<Integer> Solution94(TreeNode root) {
        Traversal(root);
        return result;
    }

    private void Traversal(TreeNode node) {
        if (node == null) {
            return;
        }

        Traversal(node.right);
        result.add(node.val);
        Traversal(node.left);
    }

    // 2331. Evaluate Boolean Binary Tree
    // You are given the root of a full binary tree with the following properties:
    //
    // Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
    // Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
    // The evaluation of a node is as follows:
    // If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
    // Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
    // Return the boolean result of evaluating the root node.
    // A full binary tree is a binary tree where each node has either 0 or 2 children.
    // A leaf node is a node that has zero children.
    // Constraints:
    // The number of nodes in the tree is in the range [1, 1000].
    // 0 <= Node.val <= 3
    // Every node has either 0 or 2 children.
    // Leaf nodes have a value of 0 or 1.
    // Non-leaf nodes have a value of 2 or 3.
    public boolean Solution2331(TreeNode root) {
        return evaluate(root);
    }

    private boolean evaluate(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val != 0;
        }

        boolean leftNodeVal = evaluate(node.left);
        boolean rightNodeVal = evaluate(node.right);

        if (node.val == 2) {
            return leftNodeVal | rightNodeVal;
        } else {
            return leftNodeVal & rightNodeVal;
        }
    }

    // 563. Binary Tree Tilt
    // Given the root of a binary tree, return the sum of every tree node's tilt.
    //
    // The tilt of a tree node is the absolute difference between
    // the sum of all left subtree node values and all right subtree node values.
    // If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
    // The rule is similar if the node does not have a right child.
    // The number of nodes in the tree is in the range [0, 104].
    // -1000 <= Node.val <= 1000
    int sum;

    public int Solution563(TreeNode root) {
        findingTilt(root);
        return sum;
    }

    private int findingTilt(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findingTilt(node.left);
        int right = findingTilt(node.right);

        sum += Math.abs(left - right);

        return left + right + node.val;
    }
}


