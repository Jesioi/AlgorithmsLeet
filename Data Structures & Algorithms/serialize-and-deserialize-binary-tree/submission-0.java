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

public class Codec {
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(arr));
        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Deque<String> queue) {
        String cur = queue.pollFirst();

        if (cur.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(cur));

        root.left = dfsDeserialize(queue);
        root.right = dfsDeserialize(queue);

        return root;
    }
}
