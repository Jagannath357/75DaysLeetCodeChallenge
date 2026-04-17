/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isEqual(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        else if(root == null || subRoot == null){
            return false;
        }
        return ( isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right) ) && root.val == subRoot.val;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isEqual(root, subRoot)){
                return true;
            }else{
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}