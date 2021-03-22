//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 865 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {                    // 记录第i个元素结尾的子数组的乘积最小值和最大值，由于有负数的存在，最小值乘以负数可能变成最大值
    public int maxProduct(int[] nums) {
        int l = nums.length;
        int res = nums[0], dp_max = nums[0], dp_min = nums[0];
        int temp;
        for (int i = 1; i < l; i++){
            temp = dp_max;
            dp_max = Math.max(Math.max(dp_max*nums[i], dp_min*nums[i]), nums[i]);
            dp_min = Math.min(Math.min(temp*nums[i], dp_min*nums[i]), nums[i]);
            res = Math.max(dp_max, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
