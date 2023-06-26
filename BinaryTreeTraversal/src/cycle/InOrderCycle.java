package cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序递归遍历
 */
public class InOrderCycle {
    public List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
