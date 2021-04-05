//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i];
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2){
                String s1 = String.valueOf(num1) + String.valueOf(num2);
                String s2 = String.valueOf(num2) + String.valueOf(num1);
                return s1.compareTo(s2);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
