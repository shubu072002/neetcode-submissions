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
        return mergeListHelper(lists,0,lists.length-1);
    }
    public ListNode mergeListHelper(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }
        if(start+1==end){
            return merge(lists[start],lists[end]);
        }
        int mid = start + (end-start)/2;
        ListNode left = mergeListHelper(lists, start, mid);
        ListNode right=  mergeListHelper(lists,mid+1,end);
        return merge(left, right);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode temp;
        if(l1.val<l2.val){
            temp = l1;
            l1=l1.next;
        }else{
            temp = l2;
            l2 = l2.next;
        }
        ListNode newHead = temp;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1=l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1==null) temp.next=l2;
        if(l2==null) temp.next=l1;
        return newHead;
    }
}