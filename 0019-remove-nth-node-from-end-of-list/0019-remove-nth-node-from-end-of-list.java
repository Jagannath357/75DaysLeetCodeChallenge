/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node helps handle cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // 1. Move fast pointer so there's a gap of n between slow and fast
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 2. Move both until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 3. Skip the nth node from the end
        slow.next = slow.next.next;
        
        // Return the actual head (which might have changed)
        return dummy.next;
    }
}