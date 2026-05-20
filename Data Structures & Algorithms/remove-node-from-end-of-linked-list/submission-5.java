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
    public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		
		//find the index of the node should be delete
		int removeIndex = len - n;
        if (removeIndex == 0) return head.next;
		
		//delete
		cur = head;
		for (int i = 0; i < removeIndex - 1; i++) {
			cur = cur.next;
		}
		ListNode temp = cur.next;
		cur.next = cur.next.next;
		temp.next = null;
		return head;

    }
}