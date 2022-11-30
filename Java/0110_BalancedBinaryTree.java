/**
 * Number: 110
 * Title: Balanced Binary Tree
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 * Tags: Tree, Depth-First Search, Binary Tree
 * Difficulty: Easy
 * Content: Given a binary tree, determine if it is height-balanced.
 * 
 * Original runtime: N/A (unsolved)
 * Original space: N/A (unsolved)
 * 
 * Improved runtime: 1ms (99.17%)
 * Improved space: 43.9MB (72.29%)
 */

 /**
  *  Note: originally solved wrong problem -- height balanced does NOT mean
  * that the height is minimized overall, but rather that the height of the
  * left and right subtrees (of any node) differ by at most 1.
  */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return depthBalanced(root) != -1;
    }
    
    public int depthBalanced(TreeNode root){
        // trivially balanced and height 0 if root == null
        if(root == null) {
            return 0;
        }
        // get height of left and right
        int heightLeft = depthBalanced(root.left);
        if(heightLeft == -1){
            return -1;
        }
        int heightRight = depthBalanced(root.right);
        if(heightRight == -1) {
            return -1;
        }
        if(Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }
        return 1 + Math.max(heightLeft, heightRight);                
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
