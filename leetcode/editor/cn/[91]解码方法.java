//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 578 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        int[] dp = new int[l];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < l; i++){
            if (s.charAt(i) == '0'){
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2'){
                    return 0;
                } else {
                    dp[i] = i-2 >= 0 ? dp[i-2] : 1;
                }
            } else if (s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1, i+1)) <= 26){
                dp[i] = dp[i-1] + (i-2 >= 0 ? dp[i-2] : 1);
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[l-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
