//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 550 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] visit = new boolean[nums.length];
        backTracing(nums, 0, visit, new ArrayList<Integer>(), res);
        return res;
    }

    public void backTracing(int[] nums, int index, boolean[] visit, ArrayList<Integer> temp, List<List<Integer>> res){
        if (index == nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            // 剪枝条件一：当前元素已被使用过；剪枝条件二：当前元素和前一个元素相同，且前一个元素未被使用过
            if (visit[i] || (i > 0 && nums[i] == nums[i-1] && !visit[i-1])) continue;
            temp.add(nums[i]);
            visit[i] = true;
            backTracing(nums, index+1, visit, temp, res);
            visit[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
