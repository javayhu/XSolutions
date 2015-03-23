/**
 * hujiawei - 15/3/22.
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame_55 {

    public static void main(String[] args) {
        System.out.println(new JumpGame_55().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame_55().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] A) {
        int len = A.length, max = 0;//max表示当前最远能够到达的地方

        for (int i = 0; i < len; i++) {
            if (i <= max) {//表示当前这个位置可以到达
                if (i + A[i] >= max) {//需要更新能够到达的最远的位置
                    max = i + A[i];
                    if (max >= len - 1) return true;//已经能够到达最后的位置了
                }
            } else {//当前位置不可到达
                return false;
            }
        }
        return false;
    }

}
