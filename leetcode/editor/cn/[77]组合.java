//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 464 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backTracing(1, n, k, temp, res);
        return res;
    }
    public void backTracing(int begin, int n, int k, List<Integer> temp, List<List<Integer>> res){
        if (temp.size() == k){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = begin; i <= n; i++){
            temp.add(i);
            backTracing(i+1, n, k, temp, res);
            temp.remove(temp.size()-1);
        }
    }*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combineCore(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

    public void combineCore(int index, int n, int k, List<Integer> temp, List<List<Integer>> res){
        if (temp.size() == k){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = index; i <= n; i++){
            if (!temp.contains(i)){
                temp.add(i);
                combineCore(i, n, k, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
