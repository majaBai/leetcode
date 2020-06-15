import java.util.List;
/*
* Sort a linked list using insertion sort.
 */
public class InsertionSortList{

    public ListNode insertion_sort (ListNode head){
        ListNode ordered = null;
        while(head != null){
            ListNode current = head;
            head = head.next;
            ordered = insert(ordered, current);
        }
        return ordered;
    }

    public ListNode insert(ListNode head, ListNode n){
        if(head == null || n.val <= head.val){
            n.next = head;
            return n;
        }
        ListNode curr = head;
        while(curr.next != null && n.val > curr.next.val){
            curr = curr.next;
        }
        n.next = curr.next;
        curr.next = n;
        return head;
    }

    public static void main(String[] args){

    }
}