//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 160 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int index;
    public boolean isNumber(String s) {
        s = s.trim();
        index = 0;
        boolean res;
        res = isInteger(s);
        if (index < s.length() && s.charAt(index) == '.'){
            index++;
            res = isUnsignedInteger(s) || res;
        }
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')){
            index++;
            res = res && isInteger(s);
        }
        return res && (index == s.length());
    }

    public boolean isInteger(String s){
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            index++;
        }
        return isUnsignedInteger(s);
    }

    public boolean isUnsignedInteger(String s){
        int temp = index;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            index++;
        }
        return index > temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
