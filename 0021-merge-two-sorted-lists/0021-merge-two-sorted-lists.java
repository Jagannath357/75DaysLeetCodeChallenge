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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the starting point
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Iterate while both lists have nodes to compare
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer forward in the merged list
            curr = curr.next;
        }

        // If one list is finished, attach the remaining part of the other list
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        // Return the head of the merged list (skip the dummy node)
        return dummy.next;
    }
}
