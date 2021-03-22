//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1047 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        char[][] map = {{'a','b','c'},
                 {'d','e','f'},
                 {'g','h','i'},
                 {'j','k','l'},
                 {'m','n','o'},
                 {'p','q','r','s'},
                 {'t','u','v'},
                 {'w','x','y','z'}};
        List<String> res = new ArrayList<String>();
        char[] temp = new char[digits.length()];
        backTracing(map, digits, 0, temp, res);
        return res;
    }

    public void backTracing(char[][] map, String digits, int count, char[] temp, List<String> res){
        if (count == digits.length()){
            res.add(String.valueOf(temp));
            return;
        }

        int curr = Integer.parseInt(String.valueOf(digits.charAt(count)));
        for (int j = 0; j < map[curr-2].length; j++){
            temp[count] = map[curr-2][j];
            backTracing(map, digits, count+1, temp, res);
            temp[count] = ' ';
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
