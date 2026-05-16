import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ListNode> createList(ListNode head){
        ArrayList<ListNode> lst = new ArrayList<>();
        while(head != null){
            lst.add(head);
            head = head.next;
        }
        return lst;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> lstA = createList(headA);
        ArrayList<ListNode> lstB = createList(headB);
        int n1 = lstA.size();
        int n2 = lstB.size();
        ListNode ans = null;
        for(int i = n1-1, j = n2-1; i>=0 && j >= 0; i--, j--){
            if(lstA.get(i) == lstB.get(j)){
                ans = lstA.get(i);
            }
        }
        return ans;
    }
}