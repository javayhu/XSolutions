/**
 * hujiawei 15/3/28
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement_27 {

    public static void main(String[] args) {
        System.out.println(new RemoveElement_27().removeElement(new int[]{1, 2, 3, 4, 5, 3}, 2));
    }

    public int removeElement(int[] A, int elem) {
        if (null == A || A.length == 0) return 0;
        int len = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[len++] = A[i];
            }
        }
        return len;
    }
}
