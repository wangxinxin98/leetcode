//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 109 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 341 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int l = prices.length;
        if (k > l/2) return maxProfit_k_inf(prices);        // 最大交易次数超过天数的一半，相当于K为+∞的情况
        int[][][] dp = new int[l][k+1][2];
        for (int i = 0; i < l; i++) {
            for (int temp = k; temp >= 1; temp--){        // 穷举K
                if (i == 0){
                    dp[0][temp][0] = 0;             // dp[0][k][0] = max(0, -∞ + price[0])
                    dp[0][temp][1] = -prices[0];    // dp[0][k][1] = max(-∞, 0 - price[0])
                    continue;
                }
                // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
                dp[i][temp][0] = Math.max(dp[i-1][temp][0], dp[i-1][temp][1] + prices[i]);
                // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
                dp[i][temp][1] = Math.max(dp[i-1][temp][1], dp[i-1][temp-1][0] - prices[i]);
            }
        }
        return dp[l-1][k][0];
    }

    public int maxProfit_k_inf(int[] prices) {
        int l = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);      // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);        // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - price[i])
        }
        return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
