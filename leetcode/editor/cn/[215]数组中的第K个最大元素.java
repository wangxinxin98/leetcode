//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 805 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void maxHeapify(int[] array, int curr, int l){
        int maxIndex = curr;
        if (2*curr < l && array[2*curr] > array[maxIndex]) maxIndex = 2*curr;           // 左子树
        if (2*curr+1 < l && array[2*curr+1] > array[maxIndex]) maxIndex = 2*curr+1;     // 右子树
        if (maxIndex != curr){
            swap(array, curr, maxIndex);
            maxHeapify(array, maxIndex, l);
        }
    }

    public static void buildMaxHeap(int[] array){
        for (int i = array.length/2; i >= 0; i--){
            maxHeapify(array, i, array.length);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums);
        int i = nums.length;
        while (k > 1){
            swap(nums, 0, i - 1);
            maxHeapify(nums, 0, i - 1);
            i--;
            k--;
        }
        return nums[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
