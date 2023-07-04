import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * 获取二叉树的最大深度 = MAX（左子树深度， 右子树深度） + 1
     * +1是把根节点算进去
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 找左子树最大深度
        int leftDepth = maxDepth(root.left);
        // 找右子树最大深度
        int rightDepth = maxDepth(root.right);
        // 最终找两者最大值
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 非递归，与层序遍历类似
     */
    public int bfs(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result++;
        }
        return result;
    }

}
