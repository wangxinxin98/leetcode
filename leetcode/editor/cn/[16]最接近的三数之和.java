//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 631 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 1000;
        Arrays.sort(nums);
        int l = nums.length;
        int sum = 0;
        int temp = 0;
        int left = temp+1;
        int right = l-1;
        while (temp < l-2){
            while (left < right){
                sum = nums[temp] + nums[left] + nums[right];
                if (sum - target == 0){
                    return sum;
                }else{
                    if (Math.abs(sum-target) < Math.abs(res-target)){
                        res = sum;
                    }
                    if (sum - target > 0){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
            while(temp < l-2 && nums[temp+1] == nums[temp]) temp++;
            temp++;
            left = temp+1;
            right = l-1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
