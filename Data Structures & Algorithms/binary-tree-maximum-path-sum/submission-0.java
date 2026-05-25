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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;    
    }

    private int pathSum(TreeNode root) {
        if (root == null) return 0;

        //find left child max sum
        int left = pathSum(root.left);

        //find right child max sum
        int right = pathSum(root.right);

        maxSum = Math.max(maxSum, left + right + root.val);

        left = Math.max(0, left + root.val);
        right = Math.max(0, right + root.val);

        return Math.max(left, right);
    }
}
