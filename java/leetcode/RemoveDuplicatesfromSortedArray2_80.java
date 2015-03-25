/**
 * hujiawei - 15/3/24.
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesfromSortedArray2_80 {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesfromSortedArray2_80().removeDuplicates(new int[]{1, 2}));
        System.out.println(new RemoveDuplicatesfromSortedArray2_80().removeDuplicates(new int[]{1, 2, 2, 2, 3, 4, 4, 5}));
    }

    public int removeDuplicates(int[] A) {
        if (null == A || A.length == 0) return 0;
        int index = 0, count = 1;//利用count来记录出现的次数，初始化为1是因为第一个数字就算出现一次了
        for (int i = 1, l = A.length; i < l; i++) {
            if (A[i] != A[index]) {
                count = 1;//重置count，表示这个新加入的数字出现一次了
                A[++index] = A[i];//这样的写法默认A[0]不用处理了，然后出现一个不同的数字就移动一下index
            } else if (A[i] == A[index] && count == 1) {
                A[++index] = A[i];
                count++;
            }
        }
        return ++index;//长度
    }

}
