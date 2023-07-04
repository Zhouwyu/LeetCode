import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return count;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return dfs(root.left) + dfs(root.right) + 1;
    }
}
