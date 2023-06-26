import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口的个数
        int[] res = new int[nums.length - k + 1];
        // 双端队列
        LinkedList<Integer> queue = new LinkedList<>();

        // 右边界遍历
        for (int right = 0; right < nums.length; right++) {
            // 当队列非空且右边界对应的值比队列中元素大的时候，队列元素出队
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // 然后右边界对应的值（索引入队）
            queue.addLast(right);
            // 计算对应的左边界
            int left = right - k + 1;
            // 说明队头元素不在滑动窗口内了，元素出队
            if(queue.peekFirst() < left) {
                queue.removeFirst();
            }
            // 右边界到达位置，说明窗口形成，此时队头索引对应的元素即窗口内最大值
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}