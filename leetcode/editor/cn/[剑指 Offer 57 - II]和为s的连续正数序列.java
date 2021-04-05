//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target <= 1) return new int[0][0];
        ArrayList<int[]> res = new ArrayList<int[]>();
        int left = 1, right = 2;
        int sum = 3;
        while (right <= (target + 1) / 2){
            if (sum > target){
                sum -= left;
                left++;
            } else if (sum < target){
                right++;
                sum += right;
            } else {
                res.add(buildOneAns(left, right));
                right++;
                sum = sum + right - left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[] buildOneAns(int left, int right){
        int[] res = new int[right - left + 1];
        int count = 0;
        for (int i = left; i <= right; i++){
            res[count++] = i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
