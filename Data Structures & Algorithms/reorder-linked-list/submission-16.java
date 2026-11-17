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
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (head2 != null) {
            ListNode tmp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = tmp;
        }

        head2 = prev;
        ListNode cur = head;

        while (head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            
            head.next = head2;
            head2.next = tmp1;

            head = tmp1;
            head2 = tmp2;
            
            
        }

    }
}
// h     t
// 2 4 6 8
// 2 4
// 8 6
