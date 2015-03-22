import java.util.Stack;

/**
 * hujiawei - 15/3/21.
 * <p/>
 * 栈
 * <p/>
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleinHistogram_84 {

    public static void main(String[] args) {
        System.out.println(new LargestRectangleinHistogram_84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    // 两个栈的解法 http://blog.csdn.net/beiyetengqing/article/details/8258232
    // 一个栈的解法 http://www.cnblogs.com/avril/archive/2013/08/24/3278873.html
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int maxArea = 0;
        int[] newHeight = new int[height.length + 1];
        System.arraycopy(height, 0, newHeight, 0, height.length);
        newHeight[height.length] = 0;//在末尾添加一个0，保证最后栈为空了
        Stack<Integer> stackHeight = new Stack<Integer>();//保存高度值
        Stack<Integer> stackIndex = new Stack<Integer>();//保存位置索引

        for (int i = 0; i < newHeight.length; i++) {
            if (stackHeight.isEmpty() || newHeight[i] > stackHeight.peek()) {
                stackHeight.push(newHeight[i]);
                stackIndex.push(i);
            } else if (newHeight[i] < stackHeight.peek()) {
                int lastIndex = 0;
                // 一直定位(弹出栈顶)到高度小于等于当前的高度值，然后计算该连续递增区间的面积
                while (!stackHeight.isEmpty() && newHeight[i] < stackHeight.peek()) {
                    lastIndex = stackIndex.pop();
                    int tempArea = stackHeight.pop() * (i - lastIndex);
                    if (maxArea < tempArea) {
                        maxArea = tempArea;
                    }
                }
                stackHeight.push(newHeight[i]);
                stackIndex.push(lastIndex);
            }
        }
        return maxArea;
    }

}
