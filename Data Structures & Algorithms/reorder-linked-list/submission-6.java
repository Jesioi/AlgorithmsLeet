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
    public void reorderList(ListNode head) {
        ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//reverse the second half
		ListNode cur = slow.next;
		ListNode prev = null;
		slow.next = null;
		
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
            prev = cur;
			cur = temp;
		}
		
		//reorder one by on from two separe list
		// 1 -> 2 -> 3 -> null
		// 5 -> 4 -> null
		ListNode first = head;
        ListNode second = prev;
		while (second != null) {
            ListNode temp1 = first.next;
			ListNode temp2 = second.next;

			first.next = second;
			second.next = temp1;

			first = temp1;
            second = temp2;
		}
    }
}


