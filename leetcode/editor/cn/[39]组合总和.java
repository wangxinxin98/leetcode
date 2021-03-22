//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTracing(0, candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    /*
    public void backTracing(int index, int[] candidates, int target, int sum, ArrayList<Integer> temp, List<List<Integer>> res){
        if (index == candidates.length) return;
        if (sum == target){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        backTracing(index + 1, candidates, target, sum, temp, res);
        if (sum < target){
            temp.add(candidates[index]);
            backTracing(index, candidates, target, sum + candidates[index], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
     */
    public void backTracing(int begin, int[] candidates, int target, int sum, ArrayList<Integer> temp, List<List<Integer>> res){
        if (sum == target){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++){
            if (sum + candidates[i] > target) break;
            temp.add(candidates[i]);
            backTracing(i, candidates, target, sum + candidates[i], temp, res);     // 每个元素可以重复使用，下一轮搜索起点从i开始
            temp.remove(temp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
