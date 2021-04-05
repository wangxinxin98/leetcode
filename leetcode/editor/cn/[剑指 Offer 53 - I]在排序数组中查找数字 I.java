//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = findLeft(nums, target, 0, nums.length-1);
        int right = findRight(nums, target, 0, nums.length-1);
        if (left > -1 && right > -1) return right-left+1;
        return 0;
    }

    public int findLeft(int[] nums, int target, int left, int right){
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            if (mid == 0 || mid > 0 && nums[mid-1] != target){
                return mid;
            } else {
                right = mid-1;
            }
        } else if (nums[mid] < target){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return findLeft(nums, target, left, right);
    }

    public int findRight(int[] nums, int target, int left, int right){
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            if (mid == nums.length-1 || mid < nums.length-1 && nums[mid+1] != target){
                return mid;
            } else {
                left = mid+1;
            }
        } else if (nums[mid] < target){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return findRight(nums, target, left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
