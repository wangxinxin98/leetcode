//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5315 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode point = res;
        int temp = 0;
        int carry = 0;
        while(l1 != null && l2 != null){
            temp = l1.val + l2.val + carry;
            point.next = new ListNode(temp%10);
            carry = temp/10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        while(l1 != null){
            temp = l1.val + carry;
            point.next = new ListNode(temp%10);
            carry = temp/10;
            l1 = l1.next;
            point = point.next;
        }
        while(l2 != null){
            temp = l2.val + carry;
            point.next = new ListNode(temp%10);
            carry = temp/10;
            l2 = l2.next;
            point = point.next;
        }
        if (carry != 0){
            point.next = new ListNode(carry);
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
