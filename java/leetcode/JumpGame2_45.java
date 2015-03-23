import java.util.Arrays;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2_45 {

    public static void main(String[] args) {
        System.out.println(new JumpGame2_45().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame2_45().jump(new int[]{2}));
    }

    // 根据下面的jump3修改变量名得到的易于理解的版本
    public int jump(int[] A) {
        int len = A.length, result = 0;//result保存最小步数
        int cur = 0;//当前要去到达的位置
        int max = 0;//当前位置的下一步最远能够到达的位置(但是还没有到达)
        for (int i = 0; i < len; ++i) {
            if (i > cur) {//这个代表了当前的位置是前面的那些位置都无法到达的地方
                cur = max;//重新设置一个目标位置
                result++;//当走到这里的时候说明必须要在这里落脚，否则无法再往下走了
            }
            max = Math.max(max, i + A[i]);
        }
        return result;
    }

    // 参考解法代码2 http://www.acmerblog.com/leetcode-solution-jump-game-ii-6229.html
    public int jump3(int[] A) {
        int len = A.length, result = 0;
        // the maximum distance that has been reached
        int last = 0;
        // the maximum distance that can be reached by using "ret+1" steps
        int cur = 0;
        for (int i = 0; i < len; ++i) {
            if (i > last) {
                last = cur;
                ++result;
            }
            cur = Math.max(cur, i + A[i]);
        }
        return result;
    }

    // 超时
    public int jump2(int[] A) {
        int len = A.length;
        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        min[0] = 0;
        for (int i = 0; i < len; i++) {
            //标记从当前位置能够达到的其他位置
            for (int j = i + 1; j <= i + A[i] && j < len; j++) {
                min[j] = Math.min(min[i] + 1, min[j]);//
            }
            //System.out.println(Arrays.toString(min));
            //如果现在已经能够到达了就可以返回了
            if (i + A[i] >= len - 1) return min[len - 1];
        }
        return min[len - 1];
    }

}
