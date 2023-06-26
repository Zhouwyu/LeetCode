import java.util.Stack;

// https://leetcode.cn/problems/evaluate-reverse-polish-notation/
// 逆波兰表达式求值
public class Solution {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        int i = new Solution().evalRPN(tokens);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        // 利用栈的特性
        Stack<String> stack = new Stack<>();
        // 循环遍历数组内容
        for (String token : tokens) {
            // 当栈为空或数组元素是数字时，入栈
            if (stack.isEmpty() || !"+-*/".contains(token)) {
                stack.push(token);
            }
            // 数组元素是运算符时，栈中数字出栈，结合运算符进行运算，结果入栈
            else if ("+-*/".contains(token)) {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                int result = Integer.MAX_VALUE;
                switch (token) {
                    case "+":
                        result = second + first;
                        break;
                    case "-":
                        result = second - first;
                        break;
                    case "*":
                        result = second * first;
                        break;
                    case "/":
                        result = second / first;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        // 最后栈中所剩即结果
        return Integer.parseInt(stack.pop());
    }
}
