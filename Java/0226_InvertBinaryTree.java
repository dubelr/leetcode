/**
 * Number: 226
 * Title: Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 * Tags: Tree, Depth-First Search, Bredth-First Search, Binary Tree
 * Difficulty: Easy
 * Content: Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Runtime: 0ms (100.00%)
 * Space: 45.5MB (27.92%)
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // if null, return null
        if (root == null) {
            return null;
        }
        // non-mutating before reassignment (clearer but more space (still O(n)))
        // set [recur on left node] as right node
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        // set [recur on right node] as left node
        // return this node
        root.right = left;
        root.left = right;
        return root;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
