//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 421 👎 0


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();

        search(root, new ArrayList<Integer>(), res);

        return res;
    }

    public void search(TreeNode root, List<Integer> path, List<String> res){
        if (root == null) return;
        if (root.left == null && root.right == null){
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < path.size(); i++){
                s.append(path.get(i));
                s.append("->");
            }
            s.append(root.val);
            res.add(s.toString());
        }
        path.add(root.val);
        search(root.left, path, res);
        search(root.right, path, res);
        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
