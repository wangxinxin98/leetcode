//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 326 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {        // 数学解法
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            nums.add(i);
        }
        int count = 0;
        int sum = n;
        for (int i = 0; i < n-1; i++){
            count = (count + m - 1) % (sum--);
            nums.remove(count);
        }
        return nums.get(0);
    }

    /*public int lastRemaining(int n, int m) {        // 模拟链表
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            nums.add(i);
        }
        int count = 0;
        int sum = n;
        for (int i = 0; i < n-1; i++){
            count = (count + m - 1) % (sum--);
            nums.remove(count);
        }
        return nums.get(0);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
