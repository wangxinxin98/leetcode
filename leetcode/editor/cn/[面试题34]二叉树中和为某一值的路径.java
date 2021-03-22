//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
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
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSumCore(root, target, new ArrayList<Integer>(), res);
        return res;
    }

    public void pathSumCore(TreeNode root, int target, List<Integer> path, List<List<Integer>> res){
        if (root == null) return;
        path.add(root.val);
        if (target - root.val == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<Integer>(path));
        }
        if (root.left != null){
            pathSumCore(root.left, target-root.val, path, res);
        }
        if (root.right != null){
            pathSumCore(root.right, target-root.val, path, res);
        }
        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
