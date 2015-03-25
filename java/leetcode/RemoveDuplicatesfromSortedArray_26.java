/**
 * hujiawei - 15/3/24.
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesfromSortedArray_26 {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesfromSortedArray_26().removeDuplicates(new int[]{1, 2}));
        System.out.println(new RemoveDuplicatesfromSortedArray_26().removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 5}));
    }

    public int removeDuplicates(int[] A) {
        if (null == A || A.length == 0) return 0;
        int index = 0;
        for (int i = 1, l = A.length; i < l; i++) {
            if (A[i] != A[index]) {
                A[++index] = A[i];//这样的写法默认A[0]不用处理了，然后出现一个不同的数字就移动一下index
            }
        }
        return ++index;//长度
    }

}
