package cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序递归遍历
 */
public class PostOrderCycle {
    public List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
