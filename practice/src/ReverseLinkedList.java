/*
* Reverse a singly linked list.

* Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
* */

public class ReverseLinkedList{

    public static ListNode solution1(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode ordered = null;
        while(head != null){
            ListNode next = head.next;
            head.next = ordered;
            ordered = head;
            head = next;
        }
        return ordered;
    }

    public static ListNode solution(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode rest = solution(second);
        second.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args){

    }
}