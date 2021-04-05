//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 200 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        int[][] record = new int[2][6 * n];
        for (int i = 0; i < 6; i++){
            record[0][i] = 1;
        }
        int flag = 0;   // 0：使用record2记录；1：使用record1记录
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                record[1-flag][j] = 0;
            }
            for (int j = i; j < 6 * (i + 1); j++){
                record[1-flag][j] = 0;
                for (int k = j-1, l = 0; k>=0 && l < 6; k--, l++){
                    record[1-flag][j] += record[flag][k];
                }
            }
            flag = 1 - flag;
        }
        double sum = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = n-1; i < 6*n; i++){
            res[i-n+1] = (double) record[flag][i]/sum;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
