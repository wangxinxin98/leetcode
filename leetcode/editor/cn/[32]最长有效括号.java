//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 1102 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {                                    // dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2]
    public int longestValidParentheses(String s) {
        int l = s.length();
        int[] dp = new int[l];
        int res = 0;
        for (int i = 0; i < l; i++){
            dp[i] = 0;
        }
        for (int i = 1; i < l; i++){
            if (s.charAt(i) == ')'){
                if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = 2 + dp[i-1] + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
