/**
 * hujiawei 15/9/13
 * <p/>
 * 参考http://www.cnblogs.com/dolphin0520/archive/2011/08/24/2151846.html
 */
public class KMP {

    public static void main(String[] args) {
        String source = "ababcababa";
        String pattern = "ababa";
        System.out.println(kmp(source, pattern));
    }

    // KMP算法
    public static int kmp(String source, String pattern) {
        int i = 0, j = 0;
        int[] next = next(pattern);
        while (i < source.length()) {
            if (j == -1 || source.charAt(i) == pattern.charAt(j)) {//j==-1 从头开始了，S[i]=P[j] 有戏！
                i++;
                j++;//如果j==-1，这样的话就变成0了，从头开始继续匹配
            } else {
                j = next[j];
            }
            if (j == pattern.length()) return i - pattern.length();
        }
        return -1;
    }

    // 计算next数组
    public static int[] next(String pattern) {
        if (null == pattern || pattern.length() <= 0) return null;
        int[] next = new int[pattern.length()];
        int j = 0, k = -1;
        next[j] = k;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                next[j++] = k++;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
