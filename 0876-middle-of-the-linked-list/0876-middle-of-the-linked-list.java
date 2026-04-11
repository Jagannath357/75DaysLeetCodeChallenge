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
    public ListNode middleNode(ListNode head) {
        // Initialize both pointers at the start of the list
        ListNode slow = head;
        ListNode fast = head;
        
        // Iterate until the fast pointer reaches the end
        // For even lists, fast.next will be null. For odd, fast will be null.
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move 1 step
            fast = fast.next.next;  // Move 2 steps
        }
        
        // Slow is now at the middle (or the second middle for even lists)
        return slow;
    }
}