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
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length==0 || lists==null){
        return null;
       }
       return mergeLists(lists,0,lists.length-1);
    }
    public ListNode mergeLists(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }
        if(start+1==end){
            return merge(lists[start],lists[end]);
        }
        int mid = start+ (end-start)/2;

        ListNode left = mergeLists(lists,start,mid);
        ListNode right = mergeLists(lists,mid+1,end);
        return merge(left, right);
    }
    public ListNode merge(ListNode head1, ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        ListNode temp = null;
        if(head1.val<head2.val){
            temp = head1;
            head1 = head1.next;
        }
        else{
            temp = head2;
            head2 = head2.next;
        }
        ListNode newNode = temp;

        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                temp.next=head1;
                head1=head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1==null) temp.next = head2;
        if(head2==null) temp.next = head1;

        return newNode;
    }
}
