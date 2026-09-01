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
       //find middle 
       ListNode slow = head;
       ListNode fast = head;
       while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
       } 
       ListNode sechead = slow.next;
       slow.next = null;
       //reverse second head
       ListNode prev = null;
       ListNode curr = sechead;
       while(curr!=null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
       }
       //insert 2nd list into 1st
       ListNode t1 = head;
       ListNode t2 = prev;
       while(t2!=null){
        ListNode m1 = t1.next;
        ListNode m2 = t2.next;
        t1.next = t2;
        t2.next = m1;
        t1=m1;
        t2=m2;
       }
    }
}
