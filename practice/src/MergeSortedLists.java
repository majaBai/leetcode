/*
* Merge two sorted linked lists and return it as a new sorted list.
* The new list should be made by splicing together the nodes of the first two lists.
*
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
* */

public class MergeSortedLists{

    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode r = new ListNode();
        ListNode res = r;
        while(l1 != null && l2 != null){
            if(l2.val < l1.val){
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            } else{
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }
        }
        while(l1 != null){
            res.next = new ListNode(l1.val);
            l1 = l1.next;
            res = res.next;
        }
        while(l2 != null){
            res.next = new ListNode(l2.val);
            l2 = l2.next;
            res = res.next;
        }
        return r.next;
    }

    public static void main(String[] args){

    }
}