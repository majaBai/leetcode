/*
* 92. Reverse Linked List II
*Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
* */

import java.util.List;

public class ReverseLinkedList2{

    public static ListNode forwardTo(ListNode head, int n){
        if(n < 1) return null;
        ListNode cur = head;
        while(cur != null && n > 1){
            cur = cur.next;
            n--;
        }
        return cur;
    }

    public static ListNode reserveMtoN(ListNode m, int distToN, ListNode nNext){
        ListNode reserved = nNext;
        while(distToN >= 0){
            ListNode next = m.next;
            m.next = reserved;
            reserved = m;
            m = next;
            distToN--;
        }
        return reserved;
    }

    public static ListNode solution(ListNode head, int m, int n){
        if( n == 1 || m == n || head == null || head.next == null ) return head;
        ListNode beforeM = forwardTo(head, m-1);
        ListNode beforeN = forwardTo(head, n-1);

        ListNode mSelf;
        ListNode nSelf = beforeN.next;
        ListNode nNext = nSelf.next;
        if(beforeM == null){
            mSelf = head;
            ListNode reserved = reserveMtoN(mSelf,n - m, nNext);
            head = reserved;
        } else {
            mSelf = beforeM.next;
            ListNode reserved = reserveMtoN(mSelf,n - m, nNext);
            beforeM.next = reserved;
        }
      return head;
    }

    public static void main(String[] args) {

        {
            ListNode n1 = new ListNode(6);
            ListNode n2 = new ListNode(5, n1);
            ListNode n3 = new ListNode(4, n2);
            ListNode n4 = new ListNode(3, n3);
            ListNode n5 = new ListNode(2, n4);
            ListNode n6 = new ListNode(1, n5);
            int m = 1;
            int n = 4;

            ListNode r = solution(n6, m, n);
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

        {
            ListNode n1 = new ListNode(5);
            ListNode n2 = new ListNode(3, n1);

            int m = 1;
            int n = 2;
            ListNode r = solution(n2, m, n);
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
    }
}