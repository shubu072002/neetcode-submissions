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
        if(head.next==null){
            return null;
        }
      ListNode DummyNode = new ListNode(-1);
      ListNode slow = DummyNode;
      ListNode fast = DummyNode;
      DummyNode.next = head;
      for(int i=0;i<n;i++){
        fast = fast.next;
      }
      while(fast.next!=null){
        slow = slow.next;
        fast = fast.next;
      }
      slow.next = slow.next.next;
      return DummyNode.next;
    }
}
