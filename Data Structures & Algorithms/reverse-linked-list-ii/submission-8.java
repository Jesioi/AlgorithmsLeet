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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //need save:
        //remain head
        //oldHead
        //newHead
        //oldHeadPrev

        //find start and end node that need to be reversed
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }

        ListNode oldHead = cur.next;
        ListNode oldHeadPrev = cur;
        for (int i = 0; i < right - left + 1; i++) {
            cur = cur.next;
        }
        ListNode remainHead = cur.next;
        ListNode newHead = cur;

        //record oldHead, newHead, remainHead
        //reverse between left and right
        int times = right - left;
 
        ListNode prev = remainHead;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = oldHead.next;
            oldHead.next = prev;
            prev = oldHead;
            oldHead = temp;
        }
        oldHeadPrev.next = prev;
        return dummy.next;

        //oldHead -> remainHead

        //return newHead
    }
}