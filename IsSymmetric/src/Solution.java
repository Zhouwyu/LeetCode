import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node6;
        node3.left = node7;
        node3.right = node5;
        System.out.println( new Solution().bfs(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    /**
     * @param left 左子树
     * @param right 右子树
     * @return
     */
    public boolean dfs(TreeNode left, TreeNode right) {
        // 当左右子树均为空时，对称
        if(left == null && right == null) return true;
        // 当左右子树只有一边为空时，不对称
        if(left == null || right == null) return false;
        // 当左右子树两边均不为空时，比较其值，值不等则不对称
        if (left.val != right.val) return false;
        // 比较两边的值是否相等，比较方法：左子树的左孩子与右子树的右孩子比较；左子树的右孩子与右子树的左孩子比较；相等则对称
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    /**
     * 非递归，利用队列实现
     * @param root
     * @return
     */
    public boolean bfs(TreeNode root) {
        // 无根节点或只有一个根节点时，对称
        if (root == null || (root.left == null && root.right == null)) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将左右子树入队
        queue.add(root.left);
        queue.add(root.right);
        // 当队列非空
        while (!queue.isEmpty()) {
            // 左右子树一起出队
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 当两个左右子树均为null时，继续循环找下去，直至队列为空
            if (left == null && right == null) continue;
            // 当左右子树只有一个为null时，不对称，直接false
            if (left == null || right == null) return false;
            // 当左右子树均不为null，但其值不等，也不对称
            if (left.val != right.val) return false;

            // 左右子树均不为null，需要比较其值是否相等，比较：左子树的左孩子和右子树的右孩子；左子树的右孩子和右子树的左孩子
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        // 最后队列处理完毕说明对称
        return true;
    }
}
