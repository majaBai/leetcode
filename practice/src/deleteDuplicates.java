/*
* 82. Remove Duplicates from Sorted List II
*
* Given a sorted linked list, delete all nodes that have duplicate numbers,
* leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5
*
Example 2:
Input: 1->1->1->2->3
Output: 2->3
* */

public class deleteDuplicates{

    public static ListNode solution(ListNode head){
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                ListNode next = getNext(cur);
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNode getNext(ListNode node){
        while(node.next != null && node.val == node.next.val){
            node = node.next;
        }
        return node.next;
    }

    public static void main(String[] args){
        {
            ListNode n1 = new ListNode(5);
            ListNode n2 = new ListNode(4, n1);
            ListNode n3 = new ListNode(4, n2);
            ListNode n4 = new ListNode(3, n3);
            ListNode n5 = new ListNode(3, n4);
            ListNode n6 = new ListNode(2, n5);
            ListNode n7 = new ListNode(1, n6);

            ListNode r = solution(n7);
            while(r!= null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

    }
}