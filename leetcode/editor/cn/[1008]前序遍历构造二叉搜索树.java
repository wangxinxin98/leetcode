//返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。 
//
// (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right
// 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。） 
//
// 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。 
//
// 
//
// 示例： 
//
// 输入：[8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值互不相同 
// 
// Related Topics 树 
// 👍 120 👎 0


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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }

    public TreeNode build(int[] preorder, int begin, int end){
        if (begin > end) return null;
        TreeNode root = new TreeNode(preorder[begin]);
        int sep = Seek(preorder, preorder[begin], begin+1, end);
        root.left = build(preorder, begin+1, sep-1);
        root.right = build(preorder, sep, end);
        return root;
    }

    public int Seek(int[] arr,int number, int begin, int end){
        for (int index = begin; index <= end; index++) {
            if (arr[index] > number) {
                return index;
            }
        }
        return end+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
