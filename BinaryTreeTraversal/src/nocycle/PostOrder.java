package nocycle;

import cycle.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 标记右孩子是否访问过
        TreeNode rightFlag = null;

        // 与前序和中序类似
        while (root != null || !stack.isEmpty()) {
            // 不为null，入栈并一直往左
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 到最左边时
            else {
                // 获取栈顶元素
                root = stack.peek();
                // 当其存在右孩子且未被访问过时，往右孩子方向走
                if (root.right != null && root.right != rightFlag) {
                    root = root.right;
                } else {
                    // 否则直接pop出栈顶元素并访问其值
                    root = stack.pop();
                    list.add(root.val);
                    // 标记右孩子已是被访问过的
                    rightFlag = root;
                    // 置为null方便继续pop出栈顶元素
                    root = null;
                }
            }
        }
        return list;
    }
}
