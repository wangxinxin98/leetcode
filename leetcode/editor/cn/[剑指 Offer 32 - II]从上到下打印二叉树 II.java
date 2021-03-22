//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 92 👎 0


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
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        queue.offer(root);
        int count = 1;      // 记录当前层剩余节点数
        int subCount = 0;   // 记录下一层节点数
        while (!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while (count-- > 0){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                    subCount++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    subCount++;
                }
            }
            res.add(tmp);
            count = subCount;
            subCount = 0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
