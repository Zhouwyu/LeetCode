import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 依然是层序遍历那套模板修改一下
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                // 当前结点的左右孩子均为空的时候说明其是叶子结点，直接返回depth就是当前最小深度
                if (curNode.left == null && curNode.right == null) return depth;
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
        }
        return depth;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // 因为其最小深度的定义为到最近的叶子结点，故只有一边不为空，都应往此边继续遍历下去
        // 当左边为空而右边不为空时，往右走
        if (root.left == null) return minDepth(root.right) + 1;
        // 同理，往左走
        if (root.right == null) return minDepth(root.left) + 1;
        // 最后取左右子树最小深度最小值 + 1（当前结点）
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
