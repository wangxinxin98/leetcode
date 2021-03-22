//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 428 👎 0


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int begin1, int end1, int[] postorder, int begin2, int end2){
        if (begin1 > end1) return null;
        int index = Seek(inorder, postorder[end2]);
        int left_count = index-begin1;
        TreeNode root = new TreeNode(postorder[end2]);
        root.left = build(inorder, begin1, index-1, postorder, begin2, begin2+left_count-1);
        root.right = build(inorder, index+1, end1, postorder, begin2+left_count, end2-1);
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
