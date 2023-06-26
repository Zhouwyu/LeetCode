import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 建立map用于存储每个数的频率次数，key为数组中的值，value为对应出现的次数（即频率）
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 优先级队列，默认是小根堆
        // 此处优先队列默认排序的是key，因此需要重写确定自己需要的排序依据，此处重写，排序的是value
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        // 建堆操作
        for (Integer key : map.keySet()) {
            // 当队列长度小于指定的k个数时，可以继续入队（即可以加入堆中）
            if (queue.size() < k) {
                queue.add(key);
            }
            // 当对应的频率次数大于队列的队头元素（即堆顶元素）时，堆顶元素弹出，新元素入队
            else if(map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        // 最终队列中所剩的就是频率最大的前k个
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}