//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 676 👎 0


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
    public void flatten(TreeNode root) {        // 递归方法
        if (root == null) return;
        flatten(root.left);     // 1. 先把左子树和右子树展开为链表
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;       // 2. 将左子树作为右子树
        root.right = left;

        TreeNode tmp = root;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        tmp.right = right;      // 3. 将右子树接到之前左子树的末端
    }

    /*public void flatten(TreeNode root) {
        TreeNode predecessor = null;
        while (root != null){
            if (root.left != null){
                predecessor = root.left;
                while (predecessor.right != null) predecessor = predecessor.right;
                predecessor.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            } else {
                root = root.right;
            }
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
