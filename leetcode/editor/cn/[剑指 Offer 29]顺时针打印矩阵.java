//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n*m];
        boolean[][] visited = new boolean[n][m];
        int x = 0;
        int y = 0;
        int d = 0;
        for (int i = 0; i < n*m; i++){
            res[i] = matrix[x][y];
            visited[x][y] = true;
            if (x+dx[d] < 0 || x+dx[d] >= n || y+dy[d] < 0 || y+dy[d] >= m || visited[x+dx[d]][y+dy[d]]){
                d = (d+1)%4;
            }
            x = x+dx[d];
            y = y+dy[d];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
