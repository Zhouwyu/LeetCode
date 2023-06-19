import java.util.Stack;

// https://leetcode.cn/problems/evaluate-reverse-polish-notation/
// 逆波兰表达式求值
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(stack.isEmpty() || "+-*/".contains(tokens[i])){

            }
        }

        return 0;
    }
}
