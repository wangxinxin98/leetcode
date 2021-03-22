//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 378 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    直接回溯，超时
    int minSize = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (!wordList.contains(endWord)) return res;
        List<String> temp = new ArrayList<String>();
        temp.add(beginWord);
        int n = wordList.size();
        backTracing(0, n, beginWord, endWord, wordList, temp, res);
        List<List<String>> res_ = new ArrayList<List<String>>();
        for (int i = 0;i < res.size(); i++){
            if (res.get(i).size() == minSize){
                res_.add(res.get(i));
            }
        }
        return res_;
    }

    public void backTracing(int index, int n, String beginWord, String endWord, List<String> wordList, List<String> temp, List<List<String>> res){
        if (isValid(temp.get(temp.size()-1), endWord)){
            List<String> ans = new ArrayList<String>(temp);
            ans.add(endWord);
            minSize = Math.min(minSize, ans.size());
            res.add(ans);
            return;
        }
        if (index == n-1 || index > minSize-2) return;
        for (int i = 0; i < n; i++){
            if (temp.contains(wordList.get(i))) continue;
            if (temp.size() > minSize-1) break;
            if (isValid(beginWord, wordList.get(i))){
                temp.add(wordList.get(i));
                backTracing(index+1, n, wordList.get(i), endWord, wordList, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isValid(String s1, String s2){       // 判断s1到s2是否可转换
        int l = s1.length();
        int count = 0;
        for (int i = 0; i < l ; i++){
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1 ? true : false;
    }
     */

}
//leetcode submit region end(Prohibit modification and deletion)
