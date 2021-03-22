//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 361 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        backTracing(0, visit, nums, temp, res);
        return res;
    }

    public void backTracing(int index, boolean[] visit, int[] nums, List<Integer> temp, List<List<Integer>> res){
        if (index <= nums.length){
            res.add(new ArrayList<Integer>(temp));
        }

        for (int i = index; i < nums.length; i++){
            if (visit[i] || (i>index && nums[i] == nums[i-1] && !visit[i-1])) continue;
            temp.add(nums[i]);
            visit[i] = true;
            backTracing(i+1, visit, nums, temp, res);
            temp.remove(temp.size()-1);
            visit[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
