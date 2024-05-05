package bst;

public class Solution_0504 {
    // 104. Maximum Depth of Binary Tree
    // Given the root of a binary tree, return its maximum depth.
    // A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //
    // Constraints:
    // The number of nodes in the tree is in the range [0, 104].
    // -100 <= Node.val <= 100
    public int Solution104(TreeNode root) {
        return CalculateDepth(root, 0);
    }

    private int CalculateDepth(TreeNode node, int count) {
        if(node == null) return count;

        return Math.max(CalculateDepth(node.left, count+1), CalculateDepth(node.right, count+1));
    }

    // 100. Same Tree
    // Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    // Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    //
    // Constraints:
    // The number of nodes in both trees is in the range [0, 100].
    // -104 <= Node.val <= 104
    public boolean Solution100(TreeNode p, TreeNode q) {
        return isSameTreeHelper(p, q);
    }

    private boolean isSameTreeHelper(TreeNode firstNode, TreeNode secondNode) {
        if(firstNode == null && secondNode == null) {
            return true;
        } else if(firstNode == null || secondNode == null) {
            return false;
        }

        if(firstNode.val == secondNode.val) {
            return isSameTree(firstNode.left, secondNode.left)
                    && isSameTree(firstNode.right, secondNode.right);
        } else {
            return false;
        }
    }

    // 226. Invert Binary Tree
    // Given the root of a binary tree, invert the tree, and return its root.
    //
    // Constraints:
    // The number of nodes in the tree is in the range [0, 100].
    // -100 <= Node.val <= 100
    public TreeNode Solution226(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    private void invertTreeHelper(TreeNode node) {
        if(node.left == null && node.right == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTreeHelper(node.left);
        invertTreeHelper(node.right);
    }

    // 572. Subtree of Another Tree
    // Given the roots of two binary trees root and subRoot,
    // return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
    //
    // A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
    // The tree could also be considered as a subtree of itself.
    //
    // Constraints:
    // The number of nodes in the root tree is in the range [1, 2000].
    // The number of nodes in the subRoot tree is in the range [1, 1000].
    // -104 <= root.val <= 104
    // -104 <= subRoot.val <= 104
    public boolean Solution572(TreeNode root, TreeNode subRoot) {
        return isSubtreeHelper(root, subRoot);
    }

    private boolean isSubtreeHelper(TreeNode node, TreeNode subNode) {
        if(node == null && subNode == null) return true;
        if(node == null || subNode == null) return false;

        if(node.val == subNode.val
                && isSameTree(node, subNode)) {
            return true;
        } else {
            return isSubtreeHelper(node.left, subNode)
                    || isSubtreeHelper(node.right, subNode);
        }
    }

    private boolean isSameTree(TreeNode node, TreeNode subNode) {
        if(node == null && subNode == null) return true;
        if(node == null || subNode == null) return false;

        if(node.val == subNode.val) {
            return isSameTree(node.right, subNode.right) && isSameTree(node.left, subNode.left);
        } else {
            return false;
        }
    }

    // 235. Lowest Common Ancestor of a Binary Search Tree
    // Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
    //
    // According to the definition of LCA on Wikipedia:
    // “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q
    //  as descendants (where we allow a node to be a descendant of itself).”
    // Constraints:
    //
    // The number of nodes in the tree is in the range [2, 105].
    // -109 <= Node.val <= 109
    // All Node.val are unique.
    // p != q
    // p and q will exist in the BST.
    public TreeNode Solution235(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(Math.min(q.val, p.val) <= root.val
                && root.val <= Math.max(q.val, p.val)) {
            return root;
        } else {
            TreeNode temp = Solution235(root.left, p, q);
            if(temp != null) return temp;
            else return Solution235(root.right, p, q);
        }
    }

}
