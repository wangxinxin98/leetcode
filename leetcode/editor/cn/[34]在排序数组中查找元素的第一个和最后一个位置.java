//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 670 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int l = nums.length;
        int right = l-1;
        int mid = (left+right)/2;
        int[] res = {-1, -1};
        while (left<=right){
            if (nums[mid] == target){
                break;
            }else if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        if (left<=right){
            res[0] = mid;
            res[1] =mid;
            while (res[0] > 0 && nums[res[0]-1] == nums[res[0]]) res[0]--;
            while (res[1] < l-1 && nums[res[1]+1] == nums[res[1]]) res[1]++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
