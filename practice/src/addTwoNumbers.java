/*
* You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order and each of their nodes contain a single digit.
* Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*
* */

import java.util.ArrayList;
import java.util.Arrays;


public class addTwoNumbers{

    public static ListNode solution(ListNode l1, ListNode l2){
//        extra space (ArrayList r) is unnecessary
        ArrayList r = new ArrayList();
        ListNode h1 = l1, h2 = l2;
        while(h1 != null && h2 != null){
           int sum = h1.val + h2.val;
           r.add(sum);
           h1 = h1.next;
           h2 = h2.next;
        }
        while(h1 != null){
            r.add(h1.val);
            h1 = h1.next;
        }
        while(h2 != null){
            r.add(h2.val);
            h2 = h2.next;
        }
        int reminder = 0;
        ListNode res = new ListNode();
        ListNode hr = res;
        for(Object num : r){
            int m = (int) num;
            if(reminder != 0){
                m += reminder;
                reminder = 0;
            }
            if(m >= 10){
                reminder = 1;
                m = m - 10;
            }
            ListNode temp = new ListNode(m);
            hr.next = temp;
            hr = hr.next;
        }
        if(reminder == 1){
            ListNode temp = new ListNode(reminder);
            hr.next = temp;
        }
        return res.next;
    }

    public static ListNode solution2(ListNode l1, ListNode l2){
        ListNode res = new ListNode();
        int reminder = 0;
        ListNode curr = res;
        while(l1 != null || l2 !=null){
            int f1 = l1 != null? l1.val : 0;
            int f2 = l2 != null? l2.val: 0;
            int sum = f1+f2+reminder;
            reminder = sum /10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(reminder > 0){
            ListNode temp = new ListNode(reminder);
            curr.next = temp;
        }
        return res.next;
    }


    public static void main(String[] args){
        {
            ListNode n1 = new ListNode(3);
            ListNode n2 = new ListNode(4, n1);
            ListNode n3 = new ListNode(2, n2);

            ListNode d1 = new ListNode(4);
            ListNode d2 = new ListNode(6, d1);
            ListNode d3 = new ListNode(5, d2);

            ListNode r = solution2(n3, d3);
            while(r != null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
        {
            ListNode n1 = new ListNode(9);

            ListNode d1 = new ListNode(1);
            ListNode d2 = new ListNode(9, d1);
            ListNode d3 = new ListNode(9, d2);
            ListNode d4 = new ListNode(9, d3);
            ListNode d5 = new ListNode(9, d4);
            ListNode d6 = new ListNode(9, d5);
            ListNode d7 = new ListNode(9, d6);
            ListNode d8 = new ListNode(9, d7);
            ListNode d9 = new ListNode(9, d8);
            ListNode d0 = new ListNode(9, d9);

            ListNode r = solution2(n1, d0);
            while(r != null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

    }
}