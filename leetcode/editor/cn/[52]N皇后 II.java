//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
        int res = 0;
        int[] temp = new int[n];
        res = backTracing(temp, 0, n);
        return res;
    }

    public int backTracing(int[] temp, int count, int n){
        if (count == n) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            temp[count] = i;
            if (isValid(temp, count)){
                res += backTracing(temp, count+1, n);
            }
            temp[count] = 0;
        }

        return res;
    }

    public boolean isValid(int[] ans, int count){
        for (int i = 0; i < count; i++){
            if (ans[i] == ans[count] || Math.abs(ans[i] - ans[count]) == Math.abs(i - count)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
