/**
 * hujiawei - 15/3/21.
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater_11().maxArea(new int[]{1, 3, 4, 2, 5}));
    }

    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > max) max = area;
            if (height[j] > height[i]) i++;
            else j--;
        }
        return max;
    }

}
