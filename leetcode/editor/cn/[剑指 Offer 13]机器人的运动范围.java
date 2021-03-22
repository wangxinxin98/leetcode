//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] x = {0, 1, 0, -1};   // 右下左上
    int[] y = {1, 0, -1, 0};
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        return movingCountBacktrace(m, n, map, k, 0, 0);
    }

    public int movingCountBacktrace(int m, int n, int[][] map, int k, int i, int j){
        int count = 0;
        if (i >= 0 && i < m && j >= 0 && j < n && check(i, j) <= k && map[i][j] == 0){
            count++;
            map[i][j] = 1;
            for (int a = 0; a < 4; a++){
                count += movingCountBacktrace(m, n, map, k, i+x[a], j+y[a]);
            }
        }
        return count;
    }

    public int check(int i, int j){
        int sum = 0;
        while (i > 0){
            sum += i%10;
            i /= 10;
        }
        while (j > 0){
            sum += j%10;
            j /= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
