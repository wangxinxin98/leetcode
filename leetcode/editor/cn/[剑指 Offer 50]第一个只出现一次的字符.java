//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 81 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() <= 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        map.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++){
            int index = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), index+1);
            if (s.charAt(i) == s.charAt(res)){
                while (res <= i){
                    if (map.get(s.charAt(res)) != 1) res++;
                    else break;
                }
            }
        }
        return res < s.length() ? s.charAt(res) : ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
