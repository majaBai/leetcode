/*
* Given a linked list and a value x,
* partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*
* */

public class PartitionList{

    public static ListNode solution(ListNode head, int x){
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode lt = new ListNode();
        ListNode gt = new ListNode();
        ListNode lt_Head = null;
        ListNode gt_head = null;
        while(cur != null){
            if(cur.val < x){
                lt.next = cur;
                if(lt_Head == null) lt_Head = lt.next;
                lt = lt.next;
            } else {
                gt.next = cur;
                if(gt_head == null) gt_head = gt.next;
                gt = gt.next;
            }
            cur = cur.next;
        }

        if(lt_Head == null){
            return gt_head;
        } else {
            lt.next = gt_head;
            gt.next = null;
            return lt_Head;
        }
    }

    public static void main(String[] args){

        {
            ListNode n1 = new ListNode(2);
            ListNode n2 = new ListNode(5, n1);
            ListNode n3 = new ListNode(2, n2);
            ListNode n4 = new ListNode(3, n3);
            ListNode n5 = new ListNode(4, n4);
            ListNode n6 = new ListNode(1, n5);

            int x = 3;
            ListNode r = solution(n6, x);
            while(r!= null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(1, n1);
            int x = 0;
            ListNode r = solution(n2, x);
            while(r!= null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

    }
}