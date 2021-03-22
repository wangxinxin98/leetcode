//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 703 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {        // 数字从大到小，坐标从后往前排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr1 = m-1;
        int curr2 = n-1;
        int temp = nums1.length-1;
        while (curr1 >= 0 && curr2 >= 0){
            if (nums1[curr1] >= nums2[curr2]) nums1[temp--] = nums1[curr1--];
            else if (nums2[curr2] > nums1[curr1]) nums1[temp--] = nums2[curr2--];
        }
        while (curr2 >= 0) nums1[temp--] = nums2[curr2--];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
