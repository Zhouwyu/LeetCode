package nocycle;

import cycle.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    }

    /**
     * 变化后的做法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 在每次出队之前记录下当前队列结点个数，因为此时队列中的结点都是同一层的
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // 批量处理同一层的结点
            for (int i = 0; i < size; i++) {
                // 出队
                TreeNode node = queue.poll();
                // 访问
                list.add(node.val);
                // 左孩子入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 右孩子入队
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resultList.add(list);
        }
        return resultList;
    }

    /**
     * 常规做法
     * @param root
     * @return
     */
    public static List<Integer> levelorder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
