//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
// 例如，给出 n
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 317 👎 0


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int left_p, int right_p, int left_i, int right_i){
        if (left_p > right_p) return null;
        TreeNode root = new TreeNode(preorder[left_p]);
        int pos = seek(inorder, preorder[left_p]);
        int leftSize = pos - left_i;
        root.left = construct(preorder, inorder, left_p+1, left_p+leftSize, left_i, pos-1);
        root.right = construct(preorder, inorder, left_p+leftSize+1, right_p, pos+1, right_i );
        return root;
    }

    public int seek(int[] inorder, int target){
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == target) return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
