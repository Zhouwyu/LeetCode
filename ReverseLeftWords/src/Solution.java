public class Solution {
    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        System.out.println(reverseLeftWords(s, n));
    }

    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] sChar = s.toCharArray();
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = sChar[i];
        }
        int j;
        for (j = n; j < len; j++) {
            sChar[j - n] = sChar[j];
        }
        for(int k = 0; k < temp.length; k++) {
            sChar[j - n] = temp[k];
            j++;
        }
        return String.valueOf(sChar);
    }
}