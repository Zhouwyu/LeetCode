
public class ReverseWordsInStr {
    public static void main(String[] args) {
        String s = "a good   example";
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWords(sb);
        System.out.println(sb.toString());
    }



    public static StringBuilder removeSpace(String str) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = str.length() - 1;
        // 去除头尾的空格
        while (str.charAt(start) == ' ') start++;
        while (str.charAt(end) == ' ') end--;
        // 去除中间多余的空格
        while (start <= end) {
            char c = str.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void reverseEachWords(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int sbLen = sb.length();
        while (start < sbLen) {
            // 不为空格表明还不是一个完整的单词
            while (end < sbLen && sb.charAt(end) != ' ') {
                end++;
            }
            // 完整的单词，开始单词反转
            reverseString(sb, start, end - 1);
            // 寻找下一个单词
            start = end + 1;
            end = start + 1;
        }
    }
}