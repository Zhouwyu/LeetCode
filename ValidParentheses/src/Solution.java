import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String  s = "()";
        new Solution().isValid(s);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] eachChar = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 遍历到左括号，把相应右括号入栈
            if (eachChar[i] == '(') {
                stack.push(')');
            } else if (eachChar[i] == '{') {
                stack.push('}');
            } else if (eachChar[i] == '[') {
                stack.push(']');
            }
            // 当字符串尚未被遍历完而栈为空时，说明右方向有多余括号
            // 当栈顶元素与当前遍历字符不等时，说明有括号类型不匹配
            else if (stack.isEmpty() || stack.peek() != eachChar[i]) {
                return false;
            } else {
                // 匹配到相应的左括号，右括号出栈
                stack.pop();
            }
        }
        // 遍历完毕后，栈也应该为空
        return stack.isEmpty();
    }
}