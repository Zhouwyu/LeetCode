import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(treeNode.val);
    }

    /**
     * 非递归，BFS
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 左右子树交换，利用队列存储当前左右子树的父节点
        while (!queue.isEmpty()) {
            // 每次出队的都是当前的父节点
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        // 返回翻转后的根节点
        return root;
    }

    /**
     * 递归操作，DFS
     * @param root
     * @return
     */
    public TreeNode invertTreeCycle(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeCycle(root.left);
        invertTreeCycle(root.right);
        return root;
    }
}
