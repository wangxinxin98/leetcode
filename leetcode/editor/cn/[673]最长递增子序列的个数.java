//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划 
// 👍 248 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];          // 以i结尾的最长子序列的长度
        int[] count = new int[l];       // 以i结尾的最长子序列的个数
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for (int i = 1; i < l; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    if (dp[j] + 1 > dp[i]){         // 第一次遇到以i结尾长度为dp[j]+1的子序列，组合数为count[j]个
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]){ // 再次遇到以i结尾长度为dp[j]+1的子序列，组合数加上count[j]个
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < l; i++){
            if (dp[i] == max){
                res += count[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
