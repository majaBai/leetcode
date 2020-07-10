/*
* Given a linked list, remove the n-th node from the end of list and return its head.
*
Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
*
Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?
*
* */

public class RemoveNodeFromEnd{

    public static int getLength(ListNode head){
        int r = 0;
        ListNode curr = head;
        while(curr != null){
            r += 1;
            curr = curr.next;
        }
        return r;
    }

    public static ListNode solution(ListNode head, int n){
        int len = getLength(head);
        if(n > len || n == 0) return head;
        if(len == n) return head.next;
        int limit = len - n + 1;
        ListNode curr = head;
        while(limit > 2){
            curr = curr.next;
            limit--;
        }
        ListNode next = curr.next.next;
        curr.next = next;
        return head;
    }

    public static void main(String[] args){
        {
            ListNode n1 = new ListNode(5);
            ListNode n2 = new ListNode(4, n1);
            ListNode n3 = new ListNode(3, n2);
            ListNode n4 = new ListNode(2, n3);
            ListNode n5 = new ListNode(1, n4);

            int n = 2;
            ListNode h = solution(n5, n);
            while(h != null){
                System.out.print(h.val + " ");
                h = h.next;
            }
            System.out.println();
        }
        {
            ListNode n5 = new ListNode(1);

            int n = 1;
            ListNode h = solution(n5, n);
            while(h != null){
                System.out.print(h.val + " ");
                h = h.next;
            }
            System.out.println();
        }
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2, n1);

            int n = 2;
            ListNode h = solution(n2, n);
            while(h != null){
                System.out.print(h.val + " ");
                h = h.next;
            }
            System.out.println();
        }


    }
}