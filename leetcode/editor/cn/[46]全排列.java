//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1055 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        for (int num :
                nums) {
            temp.add(num);
        }
        int n = nums.length;
        backTracing(n, nums, 0, temp, res);
        return res;
    }

    public void backTracing(int n, int[] nums, int begin, List<Integer> temp, List<List<Integer>> res){
        if (begin == n){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = begin; i < n; i++){
            Collections.swap(temp, begin, i);
            backTracing(n, nums, begin+1, temp, res);
            Collections.swap(temp, begin, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
