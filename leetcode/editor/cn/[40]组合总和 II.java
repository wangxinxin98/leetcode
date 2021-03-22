//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void backTracing(int[] candidates, int target, int sum, int begin, ArrayList<Integer> temp, List<List<Integer>> res){
        if (sum == target){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++){
            if (sum + candidates[i] > target) break;
            if (i > begin && candidates[i] == candidates[i-1]) continue;    // 同一层数值相同，剪枝
            temp.add(candidates[i]);
            backTracing(candidates, target, sum+candidates[i], i+1, temp, res);     // 每个元素不可以重复使用，下一轮搜索起点从i+1开始
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
