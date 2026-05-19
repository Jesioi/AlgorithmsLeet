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
        ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		
		while (l1 != null || l2 != null) {
			//add l1.val + l2.val + carry, 预处理carry
			int sum = carry;
			
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			//add sum % 10 to list, and sum / 10 to carry
            carry = sum / 10;
			if (sum / 10 > 0) {
				cur.next = new ListNode(sum % 10);
			} else {
				cur.next = new ListNode(sum);
			}
			
			cur = cur.next;
		}
        if (carry > 0) cur.next = new ListNode(carry);
		return dummy.next;
    }
}
