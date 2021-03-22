//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 104 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心算法 队列 数组 
// 👍 544 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> record = new HashMap<Character, Integer>();
        for (char c :
                tasks) {
            record.put(c, record.getOrDefault(c, 0) + 1);
        }

        int m = record.size();
        ArrayList<Integer> nextValid = new ArrayList<Integer>();        // 用于记录这个任务最早可执行的时间
        ArrayList<Integer> rest = new ArrayList<Integer>();             // 用于记录这个任务还剩多少次需要执行
        Set<Map.Entry<Character, Integer>> entrySet = record.entrySet();
        for (Map.Entry<Character, Integer> entry :
                entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int currTime = 0;
        for (int i = 0; i < tasks.length; ++i){
            ++currTime;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; ++j){                                // 找到所有任务中最早可执行的时间
                if (rest.get(j) != 0){
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            currTime = Math.max(currTime, minNextValid);
            int opt = -1;
            for (int j = 0; j < m; ++j){                                // 找到当前时间之前可执行的任务中的最优选择（剩余次数最多的）
                if (rest.get(j) != 0 && nextValid.get(j) <= currTime){
                    if (opt == -1 || rest.get(j) > rest.get(opt)){
                        opt = j;
                    }
                }
            }
            nextValid.set(opt, currTime + n + 1);
            rest.set(opt, rest.get(opt) - 1);
        }
        return currTime;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
