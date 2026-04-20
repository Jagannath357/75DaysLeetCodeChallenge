/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public ArrayList<TreeNode> getParents(TreeNode root, TreeNode child){
        ArrayList<TreeNode> p = new ArrayList<>();
        if(root.val == child.val){
            p.add(root);
            return p;
        }
        else if(root.left != null && root.left.val == child.val){
            p.add(root);
            p.add(root.left);
            return p;
        }else if(root.right != null && root.right.val == child.val){
            p.add(root);
            p.add(root.right);
            return p;
        }
        while(root != null){
            p.add(root);
            if(root.val == child.val) break;
            if(child.val > root.val) root = root.right;
            else root = root.left;
        }
        return p;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ppa = getParents(root, p);
        ArrayList<TreeNode> qpa = getParents(root, q);
        TreeNode parent = null;
        for(int i = 0; i < ppa.size() && i < qpa.size(); i++){
            if(ppa.get(i).val == qpa.get(i).val){
                parent = ppa.get(i);
            }
        }
        return parent;
    }
}