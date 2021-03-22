//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 243 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTracing(1, 0, k, n, new ArrayList<Integer>(), res);
        return res;
    }

    public void backTracing(int begin, int sum, int k, int target, ArrayList<Integer> temp, List<List<Integer>> res){
        if (sum == target && temp.size() == k){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = begin; i <= 9; i++){
            if (temp.size() >= k) break;        // 超过k个数，剪枝
            if (sum + i > target) break;
            temp.add(i);
            backTracing(i+1, sum + i, k, target, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
