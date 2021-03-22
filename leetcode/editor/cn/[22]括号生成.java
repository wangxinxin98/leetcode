//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1489 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        int left = 0, right = 0;
        backTracing(left, right, n, new StringBuffer(), res);
        return res;
    }

    public void backTracing(int left, int right, int n, StringBuffer temp, List<String> res){
        if (temp.length() == 2*n){
            res.add(temp.toString());
            return;
        }


        if (left < n) {
            temp.append('(');
            backTracing(left+1, right, n, temp, res);
            temp.deleteCharAt(left + right);
        }
        if (left > right){
            temp.append(')');
            backTracing(left, right+1, n, temp, res);
            temp.deleteCharAt(left + right);
        }

        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
