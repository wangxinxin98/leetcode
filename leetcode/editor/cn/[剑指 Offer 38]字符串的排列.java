//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 228 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        LinkedList<String> res = new LinkedList<>();
        char[] ch = s.toCharArray();
        permutationCore(ch, res, 0);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void permutationCore(char[] ch, LinkedList<String> res, int index){
        if (index == ch.length){
            res.addLast(String.valueOf(ch));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < ch.length; i++){
            if (set.contains(ch[i])) continue;;
            set.add(ch[i]);
            swap(ch, index, i);
            permutationCore(ch, res, index+1);
            swap(ch, index, i);
        }
    }

    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
