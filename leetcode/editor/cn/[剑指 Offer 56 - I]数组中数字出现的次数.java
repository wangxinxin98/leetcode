//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 361 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {        // 异或实现
        int tmp = 0;
        for (int i: nums){
            tmp ^= i;
        }
        int pos = 1;
        while ((pos & tmp) == 0){
            pos <<= 1;
        }
        int res1 = 0, res2 = 0;
        for (int i: nums){
            if ((pos & i) == 0) {
                res1 ^= i;
            } else {
                res2 ^= i;
            }
        }
        return new int[]{res1, res2};
    }

    /*public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) == 1){
                res.add(nums[i]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
