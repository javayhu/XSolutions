/**
 * hujiawei - 15/3/23.
 * <p/>
 * 排序
 * <p/>
 * http://www.acmerblog.com/leetcode-solution-first-missing-positive-6304.html
 */
public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0 || (A.length == 1 && A[0] != 1)) return 1;
        // 下面的for循环实际上就是让每个A[i]尽可能正确地放在对的位置上(A[i]-1上)
        for (int i = 0, size = A.length; i < size; i++) {
            while (A[i] != i + 1) {//表示A[i]不应该是放在这个位置上
                //A[i]实际应该放在A[i]-1这个位置上
                if (A[i] - 1 >= 0 && A[i] - 1 < size && A[i] != A[A[i] - 1]) {
                    swap(A, i, A[i] - 1);
                } else {
                    break;//可能是一些特殊的数字，暂时没办法确定把它放在哪里
                }
            }
        }
        // 下面的for循环就是为了找到当前位置上数字错误的地方，第一个发生错误的地方就是解
        for (int i = 0, size = A.length; i < size; i++) {
            if ((A[i] != i + 1)) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
