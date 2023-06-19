public class Solution2 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, chars.length - 1);
        reverseString(sb, 0, chars.length - 1);
        return sb.toString();
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
}
