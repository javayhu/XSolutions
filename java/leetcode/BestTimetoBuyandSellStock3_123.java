import java.util.Arrays;

/**
 * hujiawei - 15/3/21.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimetoBuyandSellStock3_123 {

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock3_123().maxProfit(new int[]{1, 2}));
        System.out.println(new BestTimetoBuyandSellStock3_123().maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[] f = new int[len];//f[i]表示从0到i的最大利润
        int[] g = new int[len];//g[j]表示从j到n-1的最大利润

        for (int i = 1, low = prices[0]; i < len; i++) {
            if (prices[i] < low) {
                low = prices[i];
                f[i] = f[i - 1];
            } else {
                f[i] = Math.max(prices[i] - low, f[i - 1]);
            }
        }
        for (int j = len - 2, high = prices[len - 1]; j >= 0; j--) {
            if (prices[j] > high) {
                high = prices[j];
                g[j] = g[j + 1];
            } else {
                g[j] = Math.max(high - prices[j], g[j + 1]);
            }
        }

        //System.out.println(Arrays.toString(f));
        //System.out.println(Arrays.toString(g));

        int max = 0;
        for (int k = 0; k < len - 1; k++) {//最多进行两次交易
            if (f[k] + g[k] > max) max = f[k] + g[k];
        }

        return max;
    }


}
