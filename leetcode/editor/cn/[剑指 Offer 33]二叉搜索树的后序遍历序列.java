//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int l = postorder.length;
        return verifyPostorderCore(postorder, 0, l-1);
    }

    public boolean verifyPostorderCore(int[] postorder, int left, int right){
        if (right - left <= 1) return true;
        int root = postorder[right];
        int i = left;
        for (; i <= right-1; i++){
            if (postorder[i] > root){
                break;
            }
        }
        int j = i;
        for (; j <= right-1; j++){
            if (postorder[j] < root){
                return false;
            }
        }
        return verifyPostorderCore(postorder, left, i-1) &&
                verifyPostorderCore(postorder, i, right-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
