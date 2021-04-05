//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 204 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        char[] str = String.valueOf(num).toCharArray();
        ArrayList<String> res = new ArrayList<>();
        translateNumCore(0, str, new StringBuilder(), res);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
        return res.size();
    }
    public void translateNumCore(int index, char[] nums, StringBuilder temp, ArrayList<String> res){
        if (index == nums.length){
            res.add(temp.toString());
            return;
        }
        temp.append((char) (nums[index] - '0' + 'a'));
        translateNumCore(index+1, nums, temp, res);
        temp.deleteCharAt(temp.length() - 1);
        if (index+1 < nums.length && (nums[index] == '1'
                || (nums[index] == '2' && nums[index+1] < '6' && nums[index+1] >= '0'))){
            temp.append((char) (((nums[index]-'0') * 10 + (nums[index+1]-'0'))+'a'));
            translateNumCore(index+2, nums, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
