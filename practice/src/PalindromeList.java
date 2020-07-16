/*
*Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
* Follow up:
Could you do it in O(n) time and O(1) space?
* */

public class PalindromeList{

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode rest = reverse(second);
        second.next = head;
        head.next = null;
        return rest;
    }
    public static ListNode copy(ListNode head){
        ListNode newHead = null;
        ListNode cur = null;
        ListNode temp = head;
        while (temp != null){
            ListNode node = new ListNode(temp.val);
            if(newHead == null) {
                newHead = node;
                cur = newHead;
            } else {
                cur.next = node;
                cur = cur.next;
            }
            temp = temp.next;
        }
        return newHead;
    }
    public static boolean solution(ListNode head){
        if(head == null || head.next == null ) return true;
        ListNode copyHead = copy(head);
        ListNode re = reverse(head);
        while(copyHead != null){
            if(copyHead.val != re.val) return false;
            copyHead = copyHead.next;
            re = re.next;
        }
        return true;
    }


    public static void main(String[] args){
        {
            ListNode n4 = new ListNode(1);
            ListNode n3 = new ListNode(2, n4);
            ListNode n2 = new ListNode(1, n3);
            ListNode n1 = new ListNode(1, n2);

            boolean r = solution(n1);
            System.out.println(r);
        }

        {
            ListNode n2 = new ListNode(2 );
            ListNode n1 = new ListNode(1, n2);

            boolean r = solution(n1);
            System.out.println(r);
        }

    }
}