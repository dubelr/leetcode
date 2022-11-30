/**
 * Number: 235
 * Title: Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Tags: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 * Difficulty: Easy
 * Content: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * Original runtime: 21ms (9.12%)
 * Original space: 49.5MB (70.46%)
 * 
 * Improved runtime: 4ms (100.00%)
 * Improved space: 49.5MB (96.95%)
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){       
        // root is less than p and q -> recur on right child
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // root is greater than p and q -> recur on left child
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // root is between p and q -> return root
        return root;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


// class SolutionOriginal {
//     ArrayList<TreeNode> pathP;
//     ArrayList<TreeNode> pathQ;
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         pathP = new ArrayList<TreeNode>();
//         pathQ = new ArrayList<TreeNode>();
//         bstRunner(root, pathP, p);
//         bstRunner(root, pathQ, q);
//         int i = 0;
//         while((i < Math.min(pathP.size(), pathQ.size()) - 1) && pathP.get(i + 1) == pathQ.get(i + 1)){
//             ++i;
//         }
//         return pathP.get(i);
//     }
    
//     // returns list of nodes from root to target node t
//     public void bstRunner(TreeNode root, ArrayList<TreeNode> path, TreeNode t){
//         TreeNode runner = root;
//         path.add(runner);
//         if (runner.val < t.val) {
//             bstRunner(root.right, path, t);
//         } else if (runner.val > t.val) {
//             bstRunner(root.left, path, t);
//         }
//         return;
//     }
// }