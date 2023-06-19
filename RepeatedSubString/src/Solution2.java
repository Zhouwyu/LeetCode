public class Solution2 {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String ss = " " + s;
        int len = ss.length();
        int[] next = new int[len];
        getNext(ss, next);
        if (next[len - 1] > 0 && s.length() % (s.length() - next[len - 1]) == 0) return true;
        return false;
    }

    public static void getNext(String neddle, int[] next){
        int left = 0;
        int right = 2;
        while (right < neddle.length()) {
            while (left > 0 && neddle.charAt(left + 1) != neddle.charAt(right)) {
                left = next[left];
            }
            if(neddle.charAt(left + 1) == neddle.charAt(right)) {
                left++;
                next[right]= left;
            }
            right++;
        }
    }
}
