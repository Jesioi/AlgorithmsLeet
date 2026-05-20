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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		
		if (head1 != null && head2 == null) {
			cur.next = head1;
		}
		
		if (head2 != null && head1 == null) {
			cur.next = head2;
		}
		return dummy.next;
    }
}