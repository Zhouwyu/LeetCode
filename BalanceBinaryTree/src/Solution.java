import java.util.LinkedList;
import java.util.Queue;

/**
 * 平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * 递归左子树的最大高度，
     * 递归右子树的最大高度
     * 作差求|BF| 若|BF|<=1则为平衡二叉树，返回-1则不是平衡二叉树
     */
    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(rightHeight - leftHeight) > 1) return -1;
        // 求最大高度
        return Math.max(rightHeight, leftHeight) + 1;
    }
}
