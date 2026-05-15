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
    public ListNode deleteDuplicates(ListNode head) {
        // Base case: if the list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        // Traverse the list until the end
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found! Skip the next node
                current.next = current.next.next;
            } else {
                // No duplicate, advance the pointer safely
                current = current.next;
            }
        }
        
        return head;
    }
}