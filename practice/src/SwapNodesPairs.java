/*
* Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
* */

public class SwapNodesPairs{

    public static ListNode solution(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = head ;
        ListNode newHead = head.next;
        while(temp != null){
            ListNode second = temp.next;
            ListNode third;
            if(second == null) {
                third = null;
            } else{
                third = second.next;
                second.next = temp;
            }
            if(third != null && third.next!= null){
                temp.next = third.next;
            } else{
                temp.next = third;
            }
            temp = third;
        }
        return newHead;
    }

    public static void main(String[] args){
        {
            ListNode t1 = new ListNode(7);
            ListNode t2 = new ListNode(6, t1);
            ListNode t3 = new ListNode(5, t2);
            ListNode t4 = new ListNode(4, t3);
            ListNode t5 = new ListNode(3, t4);
            ListNode t6 = new ListNode(2, t5);
            ListNode t7 = new ListNode(1, t6);

            ListNode r = solution(t7);
            while(r != null){
                System.out.print(r.val +" ");
                r = r.next;
            }
            System.out.println();
        }
        {
            ListNode t1 = new ListNode(5);
            ListNode t2 = new ListNode(4, t1);
            ListNode t3 = new ListNode(2, t2);

            ListNode r = solution(t3);
            while(r != null){
                System.out.print(r.val +" ");
                r = r.next;
            }
            System.out.println();
        }
    }

}