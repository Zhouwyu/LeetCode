import java.util.Stack;


// https://leetcode.cn/problems/implement-queue-using-stacks/submissions/
public class MyQueue {

    // 输入栈
    Stack<Integer> stackIn;
    // 输出栈
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // 输入栈直接push
    public void push(int x) {
        stackIn.push(x);
    }

    // 队列头元素出列并移除
    public int pop() {
        // 输出栈为空
        if(stackOut.isEmpty()) {
            // 把输入栈中的全部数据导入输出栈中
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        // 返回输出栈中的顶部元素即队头元素
        return stackOut.pop();
    }

    // 只获取队列头元素值，并不移除
    public int peek() {
        if(stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
