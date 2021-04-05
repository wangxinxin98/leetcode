//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 252 👎 0


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
    // 记录所有子树及其出现次数
    HashMap<String, Integer> map = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtreesCore(root);
        return res;
    }

    public String findDuplicateSubtreesCore(TreeNode root){
        if (root == null) return "#";
        String left = findDuplicateSubtreesCore(root.left);
        String right = findDuplicateSubtreesCore(root.right);
        String subTree = left + "," + right + "," + root.val;
        int count = map.getOrDefault(subTree, 0);
        if (count == 1) res.add(root);
        map.put(subTree, count + 1);
        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
