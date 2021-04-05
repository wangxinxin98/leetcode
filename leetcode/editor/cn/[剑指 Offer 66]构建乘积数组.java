//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 97 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        int l = a.length;
        int[] record1 = new int[l+2];
        int[] record2 = new int[l+2];
        record1[0] = 1;
        record2[l+1] = 1;
        for (int i = 1; i <= l; i++) {
            record1[i] = record1[i - 1] * a[i-1];
            record2[l-i+1] = record2[l-i+2] * a[l-i];
        }
        int[] res = new int[l];
        for (int i = 0; i < l; i++){
            res[i] = record1[i] * record2[i+2];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
