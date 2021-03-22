//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 95 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10, n) - 1];
        for (int i = 1; i < n+1; i++){
            for (char j = '1'; j <= '9'; j++){
                char[] num = new char[i];
                num[0] = j;
                dfs(1, i, num, res);
            }
        }
        return res;
    }

    void dfs(int index, int n, char[] num, int[] res){
        if (index == n){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for (char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index+1, n, num, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
