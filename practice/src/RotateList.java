/*
* 61. Rotate List
* Given a linked list, rotate the list to the right by k places, where k is non-negative.
*
Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
*
Example 2:
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
* */

public class RotateList{

    public static int getLength(ListNode head){
        int r = 0;
        ListNode t = head;
        while(t != null){
            r+=1;
            t = t.next;
        }
        return r;
    }

    public static ListNode solution(ListNode head, int k){
        int len = getLength(head);
        if(len <= 1 || k <= 0) return head;
        int mid = len - (k%len);
        if(mid == len) return head;
        ListNode curr = head;
        ListNode newHead;
        while(mid > 1){
            curr = curr.next;
            mid--;
        }
        newHead = curr.next;
        curr.next = null;
        ListNode secondStart = newHead;
        while(secondStart.next != null){
            secondStart = secondStart.next;
        }
        secondStart.next = head;
        return newHead;
    }

    public static void main(String[] args){
        {
            ListNode n1 = new ListNode(5);
            ListNode n2 = new ListNode(4, n1);
            ListNode n3 = new ListNode(3, n2);
            ListNode n4 = new ListNode(2, n3);
            ListNode n5 = new ListNode(1, n4);

            int k = 2;
            ListNode r = solution(n5, k);
            while(r!= null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
        {
            ListNode n1 = new ListNode(5);
            ListNode n2 = new ListNode(4, n1);

            int k = 5;
            ListNode r = solution(n2, k);
            while(r!= null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

    }
}