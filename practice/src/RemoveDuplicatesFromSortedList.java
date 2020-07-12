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

    public static ListNode solution2(ListNode head){
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.next.val == curr.val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
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
        {
            ListNode n1 = new ListNode(2);
            ListNode n2 = new ListNode(2, n1);
            ListNode n3 = new ListNode(2, n2);
            ListNode n4 = new ListNode(2, n3);
            ListNode n5 = new ListNode(2, n4);
            ListNode n6 = new ListNode(2, n5);
            ListNode n7 = new ListNode(2, n6);
            ListNode n8 = new ListNode(2, n7);
            ListNode n9 = new ListNode(2, n8);
            ListNode n10 = new ListNode(2, n9);
            ListNode n11 = new ListNode(2, n10);
            ListNode n12 = new ListNode(2, n11);
            ListNode n13 = new ListNode(2, n12);
            ListNode n14 = new ListNode(2, n13);
            ListNode n15 = new ListNode(2, n14);

            StopWatch timer = new StopWatch();
            ListNode r = solution(n15);
            System.out.println("solution1: " + timer.elapsedTime());
            StopWatch timer2 = new StopWatch();
            ListNode r2 = solution2(n15);
            System.out.println("solution2: " + timer2.elapsedTime());

            while(r2!= null){
                System.out.print(r.val + " ");
                r2 = r2.next;
            }
            System.out.println();
        }
    }
}