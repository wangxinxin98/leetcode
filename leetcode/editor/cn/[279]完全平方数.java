//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 703 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {                        // dp[i] = min(dp[left] + dp[right])，其中i = left + right
    public int numSquares(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i*i <= n; i++) dp[i*i] = 1;
        for (int i = 2; i <= n; i++){
            if (dp[i] == 1) continue;
            int left = 1;
            int right = i-1;
            int curr = 0;
            int min = Integer.MAX_VALUE;
            while(left<=right){
                curr = dp[left] + dp[right];
                min = Math.min(min, curr);
                left++;
                right--;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
