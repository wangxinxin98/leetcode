//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
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
// Related Topics 树 深度优先搜索 数组 
// 👍 812 👎 0


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
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2){
        if (begin1 > end1) return null;     // 前序序列中没有元素，返回null
        TreeNode root = new TreeNode(preorder[begin1]);         // 前序序列的第一个元素就是根节点
        int index = Seek(inorder, preorder[begin1]);            // 根节点在中序序列中的索引，该索引以前为左子树，以后为右子树
        int left_count = index - begin2;
        root.left = build(preorder, begin1+1, begin1+left_count, inorder, begin2, index-1); // 构建左子树
        root.right = build(preorder, begin1+left_count+1, end1, inorder, index+1, end2);        // 构建右子树
        return root;
    }

    public int Seek(int[] arr,int number){
        for (int index = 0; index<arr.length; index++) {
            if (arr[index] == number) {
                return index;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
