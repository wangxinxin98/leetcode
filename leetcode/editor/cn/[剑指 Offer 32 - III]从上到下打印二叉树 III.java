//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 86 👎 0


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.empty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            if (!stack1.empty()){
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    tmp.add(node.val);
                    if (node.left != null){
                        stack2.push(node.left);
                    }
                    if (node.right != null){
                        stack2.push(node.right);
                    }
                }
            } else {
                while (!stack2.empty()){
                    TreeNode node = stack2.pop();
                    tmp.add(node.val);
                    if (node.right != null){
                        stack1.push(node.right);
                    }
                    if (node.left != null){
                        stack1.push(node.left);
                    }
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
