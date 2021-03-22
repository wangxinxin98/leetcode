//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 500 👎 0


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
    /*
    递归算法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> res){
        if (node != null){
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }
     */

    // 非递归算法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.empty()){
            if (node != null){      // 当前节点不为空先遍历左子树
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.right != null && node.right != pre){   // 右子树不为空且未被遍历过，先遍历右子树
                    stack.push(node);
                    node = node.right;
                } else {
                    res.add(node.val);
                    pre = node;     // 记录上一个遍历的节点，若当前节点的右子树不为空，但是是上一个遍历的节点，则不重复遍历
                    node = null;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
