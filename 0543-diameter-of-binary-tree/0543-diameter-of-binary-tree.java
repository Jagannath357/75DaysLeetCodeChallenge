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
    class Info{
        int ht, dia;
        public Info(int h, int d){
            this.ht = h;
            this.dia = d;
        }
    }
    public Info getDia(TreeNode root){
        if(root == null){
            return new Info(0, 0);
        }
        Info linfo = getDia(root.left);
        Info rinfo = getDia(root.right);
        int ht = Math.max(linfo.ht, rinfo.ht) + 1;
        int d = Math.max(Math.max(linfo.dia, rinfo.dia), linfo.ht + rinfo.ht);
        return new Info(ht, d);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info data = getDia(root);
        return data.dia;
    }
}