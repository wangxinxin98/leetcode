//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        search(root, sum, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void search(TreeNode root, int sum, int temp, List<Integer> path, List<List<Integer>> res){
        if (root == null) return;

        if (temp + root.val == sum && root.left == null && root.right ==null){
            List<Integer> ans = new ArrayList<Integer>(path);
            ans.add(root.val);
            res.add(ans);
            return;
        }

        path.add(root.val);
        search(root.left, sum, temp+root.val, path, res);
        search(root.right, sum, temp+root.val, path, res);
        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
