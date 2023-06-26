package cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class PreOrderCycle {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.left = null;
        root.right = root2;
        root2.left = root3;
        System.out.println( new PreOrderCycle().preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
