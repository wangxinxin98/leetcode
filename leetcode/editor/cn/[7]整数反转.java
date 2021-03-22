//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2370 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        char[] ch = str.toCharArray();
        int l = ch.length;
        long res = 0;
        int left = 0;
        int right = l-1;
        char temp = ' ';
        if (ch[0] == '-'){
            left = 1;
        }
        while (left < right) {
            temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        str = String.valueOf(ch);
        res = Long.parseLong(str);
        if (res >= -Math.pow(2,31) && res <= Math.pow(2,31)-1){
            return (int)res;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
