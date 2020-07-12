/*
* 83. Remove Duplicates from Sorted List
* Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
* */

public class RemoveDuplicatesFromSortedList{

    public static ListNode solution(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            while(temp!=null && temp.val == curr.val){
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
        return head;
    }

    public static void main(String[] args){
        {
            ListNode n1 = new ListNode(3);
            ListNode n2 = new ListNode(3, n1);
            ListNode n3 = new ListNode(2, n2);
            ListNode n4 = new ListNode(2, n3);
            ListNode n5 = new ListNode(1, n4);

            ListNode r = solution(n5);
            while(r!= null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
    }
}