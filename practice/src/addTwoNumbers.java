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

// wrong solution:  overflow -> 9999999991 + 9
public class addTwoNumbers{

    public static String reverse(String s){
        String r = "";
        for(int i = s.length() - 1; i >= 0; i--){
            r+= s.charAt(i);
        }
        return r;
    }
    public static ListNode getNodefromStr(char s){
        ListNode n = new ListNode();
        n.val = Integer.parseInt(s + "");
        return n;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode r = new ListNode();
        String s1 = "", s2 = "";
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while(curr1 != null){
            s1 += curr1.val;
            curr1 = curr1.next;
        }
        s1 = reverse(s1);
        while(curr2 != null){
            s2 += curr2.val;
            curr2 = curr2.next;
        }
        s2 = reverse(s2);
//        overflow .... 9999999991 + 9
        long f1 = Integer.parseInt(s1);
        long f2 = Integer.parseInt(s2);
        String sum = (f1 + f2) + "";
        sum = reverse(sum);
        ListNode head = r;
        for(int i = 0; i < sum.length(); i++){
            ListNode temp = getNodefromStr(sum.charAt(i));
            head.next = temp;
            head = head.next;
        }
        return r.next;
    }



    public static void main(String[] args){

    }
}