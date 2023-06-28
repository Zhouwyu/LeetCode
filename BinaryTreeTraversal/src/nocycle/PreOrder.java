package nocycle;

import cycle.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树无递归前序遍历
 */
public class PreOrder {
    // 王道数据结构中的方法
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();
        // 先访问结点，然后入栈，先把左边的所有结点访问完；当左边访问完毕，栈中元素出栈，访问其右孩子，直至遍历完毕
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    // 入栈顺序为：中-右-左，出栈顺序：中-左-右
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        // 先把根节点入栈
        stack.push(root);

        // 栈非空，循环继续
        while (!stack.isEmpty()) {
            // 栈顶元素出栈
            TreeNode node = stack.pop();
            // 访问元素值
            list.add(node.val);
            // 右孩子非空，入栈
            if(node.right != null) {
                stack.push(node.right);
            }
            // 左孩子非空，入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

}
