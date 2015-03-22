/**
 * hujiawei - 15/3/21.
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStock2_122 {

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock2_122().maxProfit(new int[]{2, 5, 3, 8, 1, 10}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int sum = 0, low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= low) {//小于等于该低价的话就将低价设置为它，表示买这天的低价
                low = prices[i];
            } else {//大于该低价的话就表示要卖了，肯定有钱赚
                sum += prices[i] - low;//此时low要变化
                low = prices[i];
            }
        }
        return sum;
    }


}
