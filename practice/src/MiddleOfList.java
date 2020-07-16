import java.util.List;

/* Middle of the Linked List
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.
* */
public class MiddleOfList{

    public static int getLength(ListNode head){
        ListNode cur = head;
        int l = 0;
        while(cur != null){
            l++;
            cur = cur.next;
        }
        return l;
    }

    public static ListNode solution(ListNode head){
        int mid = getLength(head) / 2 + 1;
        ListNode cur = head;
        while(mid > 1){
            cur = cur.next;
            mid--;
        }
        return cur;
    }

    public static void main(String[] args){

    }
}