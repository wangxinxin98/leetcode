//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2997 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        if (l < 2) return s;
        char[] ch = s.toCharArray();
        int[][] dp = new int[l][l];
        String res = s.substring(0, 1);
        for (int i = 0; i < l ; i++){
            dp[i][i] = 1;
        }
        for (int j = 1; j < l; j++){
            for (int i = 0; i < j; i++){
                if (ch[i] == ch[j] && (j-i < 3 || dp[i+1][j-1] == 1)) dp[i][j] = 1;
                else dp[i][j] = 0;
                if (dp[i][j] == 1 && j-i+1 > res.length()){
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
