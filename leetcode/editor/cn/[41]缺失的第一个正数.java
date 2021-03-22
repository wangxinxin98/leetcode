//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 869 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {            // 首次出现的正整数一定位于[1, n+1]
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++){
            if (nums[i] <= 0) nums[i] = l+1;
        }
        int temp = 0;
        for (int i = 0; i < l; i++){
            temp = Math.abs(nums[i]);       // 有可能当前值已经被改成负数了
            if (temp <= l) nums[temp-1] = -Math.abs(nums[temp-1]);
        }
        for (int i = 0; i < l; i++){
            if (nums[i] > 0) return i+1;
        }
        return l+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
