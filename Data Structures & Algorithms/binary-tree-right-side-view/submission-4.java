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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.pollFirst();
                if (size == 1) res.add(cur.val);
                if (cur.left != null) queue.offerLast(cur.left);
                if (cur.right != null) queue.offerLast(cur.right);
                size--;
            }
        }
        return res;
    }
}
