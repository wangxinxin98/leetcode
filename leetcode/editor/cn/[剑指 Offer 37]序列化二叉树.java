//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 133 👎 0


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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeCore(root, sb);
        return sb.toString();
    }

    public void serializeCore(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.trim().split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for (String s: str){
            nodes.addLast(s);
        }
        return deserializeCore(nodes);
    }

    public TreeNode deserializeCore(LinkedList<String> nodes){
        if (nodes.isEmpty()){
            return null;
        }
        String cur = nodes.removeFirst();
        if (cur.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserializeCore(nodes);
        root.right = deserializeCore(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
