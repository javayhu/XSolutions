/**
 * hujiawei - 15/3/21.
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock_121 {

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock_121().maxProfit(new int[]{2, 5, 3, 8, 1, 10}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = 0, low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) low = prices[i];
            else if (prices[i] - low > max) max = prices[i] - low;
        }
        return max;
    }


}
