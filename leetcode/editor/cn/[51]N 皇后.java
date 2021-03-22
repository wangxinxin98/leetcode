//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 707 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<int[]> record = new ArrayList<int[]>();
        int[] temp = new int[n];
        backTracing(temp, 0, n, record);
        // System.out.println(Arrays.toString(record.get(0)));
        // System.out.println(Arrays.toString(record.get(1)));
        List<List<String>> res = outputResult(record, n);
        return res;
    }

    public void backTracing(int[] temp, int count, int n, List<int[]> record){
        if (count == n){
            // System.out.println("记录");
            record.add(Arrays.copyOf(temp, n));
            return;
        }

        for (int i = 0; i < n; i++){
            temp[count] = i;
            if (isValid(temp, count)){
                // System.out.println(Arrays.toString(temp));
                // System.out.println(count + 1);
                backTracing(temp, count+1, n, record);
            }
            temp[count] = 0;
        }
    }

    public boolean isValid(int[] ans, int count){
        for (int i = 0; i < count; i++){
            if (ans[i] == ans[count] || Math.abs(ans[i] - ans[count]) == Math.abs(i - count)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> outputResult(List<int[]> record, int n){
        List<List<String>> res = new ArrayList<List<String>>();
        String s;
        int[] currRecord = new int[n];
        for (int i = 0; i < record.size(); i++){
            List<String> temp = new ArrayList<String>();
            currRecord = record.get(i);
            for (int j = 0; j < n; j++){
                s = "";
                for (int k = 0; k < n; k++){
                    if (k == currRecord[j]){
                        s = s + "Q";
                    } else{
                        s = s + ".";
                    }
                }
                temp.add(s);
            }
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
