
class Solution {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        String subString = ss.substring(1, ss.length() - 1);
        if (subString.contains(s)) {
            return true;
        }
        return false;
    }
}