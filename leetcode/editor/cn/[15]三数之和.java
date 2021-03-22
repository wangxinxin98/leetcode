//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2779 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int l = nums.length;
        int temp = 0;
        int left = temp + 1;
        int right = l - 1;
        while (temp < l-2 && nums[temp] <= 0){
            while (left < right){
                if (nums[left] + nums[right] == -nums[temp]){
                    res.add(new ArrayList<>(Arrays.asList(nums[temp], nums[left], nums[right])));
                    while (left < l-1 && nums[left + 1] == nums[left]) left++;
                    left ++;
                    while (right > left && nums[right - 1] == nums[right]) right--;
                    right--;
                }else if(nums[left] + nums[right] > -nums[temp]){
                    right--;
                }else{
                    left++;
                }
            }
            while (temp < l-2 && nums[temp + 1] == nums[temp]) temp++;
            temp++;
            left = temp + 1;
            right = l - 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
