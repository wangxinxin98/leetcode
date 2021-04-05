//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 维护一个k个值的大根堆
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; i++){
            maxHeap.offer(arr[i]);
        }
        for (int i = k;i < arr.length; i++){
            if (maxHeap.peek() > arr[i]){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }

    /* 使用Partition函数找到index为k-1的情况
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0) return new int[0];
        if (arr.length <= k) return arr;
        int left = 0, right = arr.length-1;
        int index = partition(arr, left, right);
        while (index != k-1){
            if (index > k-1){
                index = partition(arr, left, index-1);
            } else {
                index = partition(arr, index+1, right);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public int partition(int[] nums, int left, int right){
        int temp = nums[left];
        while (left < right){
            while (left < right && nums[right] >= temp){
                right--;
            }
            if (left < right){
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] < temp){
                left++;
            }
            if (left < right){
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = temp;
        return left;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
