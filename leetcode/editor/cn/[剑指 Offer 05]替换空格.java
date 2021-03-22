//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 70 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {        // 从后往前扫描，省去往后移动数组的消耗
    public String replaceSpace(String s) {
        if (s == null) return null;
        int l = s.length();
        int count = 0;
        for (int i = 0; i < l; i++){
            if (s.charAt(i) == ' ') count++;
        }
        char[] ch = new char[l + 2*count];
        int p1 = l - 1, p2 = l + 2*count - 1;
        while (p1 >= 0){
            if (s.charAt(p1) == ' '){
                ch[p2--] = '0';
                ch[p2--] = '2';
                ch[p2--] = '%';
            } else {
                ch[p2] = s.charAt(p1);
                p2--;
            }
            p1--;
        }
        return String.valueOf(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
