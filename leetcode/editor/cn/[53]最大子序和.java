//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2675 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // *********************分治算法*********************

    /**
    public static int[] findMaxCrossingSubarray(int[] array, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i = mid; i >= low; i--){
            sum += array[i];
            if (sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid;
        for (int i = mid+1; i <= high; i++){
            sum += array[i];
            if (sum > rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }

    public static int[] findMaximumSubarray(int[] array, int low, int high){
        if (high == low) return new int[]{low, high, array[low]};
        int mid = (low + high)/2;
        int[] leftRes = findMaximumSubarray(array, low, mid);
        int[] rightRes = findMaximumSubarray(array, mid+1, high);
        int[] midRes = findMaxCrossingSubarray(array, low, mid, high);
        if (leftRes[2] >= rightRes[2] && leftRes[2] >= midRes[2]){
            return leftRes;
        }else if (rightRes[2] >= leftRes[2] && rightRes[2] >= midRes[2]){
            return rightRes;
        }else{
            return midRes;
        }
    }

    public int maxSubArray(int[] nums) {
        int[] res = findMaximumSubarray(nums, 0, nums.length-1);
        return res[2];
    }
    */

    // *********************动态规划*********************
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++){
            temp = Math.max(temp + nums[i], nums[i]);
            res = Math.max(temp, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
