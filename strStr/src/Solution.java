// KMP算法
class Solution {
    public int strStr(String haystack, String needle) {
        String newHaystack = " " + haystack;
        String newNeedle = " " + needle;
        int len1 = newHaystack.length();
        int len2 = newNeedle.length();
        // 分配next数组空间(给多一个空间，令下标从1开始)
        int[] next = new int[len2];
        // 更新next数组内容
        getNext(newNeedle, next);

        // 遍历模式串指针
        int j = 0;
        // 遍历主串指针
        int i = 1;
        while (i < len1) {
            // 主串与模式串比较，不匹配的模式串指针回退
            while (j > 0 && newHaystack.charAt(i) != newNeedle.charAt(j + 1)) {
                j = next[j];
            }
            // 匹配就往后移
            if (newHaystack.charAt(i) == newNeedle.charAt(j + 1)) {
                j++;
            }
            // 若模式串遍历完毕，则证明寻找结束
            if(j == len2 - 1) {
                // 最终返回第一个匹配的字符下标
                return i - len2 + 1;
            }
            i++;
        }
        // 没有符合的返回-1
        return  -1;
    }

    public static void getNext(String needle, int[] next) {
        int left = 0;
        int right = 2;
        // 只与模式串有关
        while (right < needle.length()) {
            // 模式串前后字符对比
            while (left > 0 && needle.charAt(right) != needle.charAt(left + 1)) {
                left = next[left];
            }
            // 有相同的前后缀，更新
            if(needle.charAt(right) == needle.charAt(left + 1)) {
                left++;
                next[right] = left;
            }
            right++;
        }
    }
}