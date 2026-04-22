/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Use a helper function to pass the range (min, max)
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // Current node's value must be strictly greater than 'low'
        if (low != null && node.val <= low) {
            return false;
        }
        // Current node's value must be strictly less than 'high'
        if (high != null && node.val >= high) {
            return false;
        }

        // Recurse left: update the high bound to current node's value
        // Recurse right: update the low bound to current node's value
        return validate(node.left, low, node.val) && 
               validate(node.right, node.val, high);
    }
}