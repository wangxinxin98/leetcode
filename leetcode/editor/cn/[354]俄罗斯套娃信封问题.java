//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {                                    // 先排序（宽度递增，宽度相同高度递减），再求最长递增子序列的长度（高度的子序列）
    public int maxEnvelopes(int[][] envelopes) {
        int l = envelopes.length;
        if (l <= 1) return l;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0]==b[0]) return b[1]-a[1];       // 宽度相同，高度按降序排列
                return a[0]-b[0];                       // 宽度按升序排列
            }
        });
        int[] dp = new int[l];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < l; i++){
            for (int j = 0; j < i; j++){
                if (envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
