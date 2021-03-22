//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 476 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backTracing(0, s, temp, res);
        return output(res);
    }

    public void backTracing(int index, String s, List<Integer> temp, List<List<Integer>> res){

        if (temp.size() == 4 && index == s.length()){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        if (temp.size() > 4 || index >= s.length()) return;

        if (s.charAt(index) == '0'){        // 当前数字为0，当前字段不能跟随其它数字
            temp.add(0);
            backTracing(index+1, s, temp, res);
            temp.remove(temp.size()-1);
        }

        int addr = 0;
        for (int i = index; i < s.length(); i++){       // 当前数字不为0，可能与后面的数字组合形成一个字段（条件：0<addr<=255）
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr > 0 && addr <= 255){
                temp.add(addr);
                backTracing(i + 1, s, temp, res);
                temp.remove(temp.size()-1);
            } else {
                break;
            }
        }
    }

    public List<String> output(List<List<Integer>> res){
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < res.size(); i++){
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < 4; j++){
                s.append(res.get(i).get(j));
                if (j != 3){
                    s.append('.');
                }
            }
            ans.add(s.toString());
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
