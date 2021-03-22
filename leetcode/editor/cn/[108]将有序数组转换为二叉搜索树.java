//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 673 👎 0


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
class Solution {        // 二叉搜索树的中序遍历为升序排列，升序中间数字为根节点，以左为左子树，以右为右子树
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int begin, int end){
        if (begin > end) return null;
        int index = (begin + end)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, begin, index-1);
        root.right = build(nums, index+1, end);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
