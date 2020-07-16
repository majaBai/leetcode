/*160. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
  Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
  Output: Reference of the node with value = 8
  Input Explanation:
* The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
* From the head of A, it reads as [4,1,8,4,5].
* From the head of B, it reads as [5,6,1,8,4,5].
* There are 2 nodes before the intersected node in A;
* There are 3 nodes before the intersected node in B.

* Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.
* */

import java.util.HashSet;

public class IntersectionOfTwoList{

    public static int getLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    public static ListNode fowardTo(ListNode start, int x){
        ListNode cur = start;
        while(x > 1 && cur != null){
            cur = cur.next;
            x--;
        }
        return cur;
    }

//    time complexity: O(N^2), time out
//    space complexity: O(1)
    public static ListNode solution1(ListNode headA, ListNode headB){
        ListNode curA = headA;
        while(curA != null){
            ListNode curB = headB;
            while(curB != null){
                if(curA == curB) return curA;
            }
            curA = curA.next;
        }
        return null;
    }

//  time complexity: O(n + K)
//  space complexity: O(n)
    public static ListNode solution2(ListNode headA, ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        ListNode curA = headA;
        while(curA != null){
            set.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB != null){
            if(set.contains(curB)) return curB;
            curB = curB.next;
        }
        return null;
    }

//  two pointer
//  space complexity: O(1)
    public static ListNode solution3(ListNode headA, ListNode headB){
        int lenA = getLength(headA), lenB = getLength(headB);

        ListNode curA = headA;
        ListNode curB = headB;
        while(lenA > lenB){
            curA = curA.next;
            lenA--;
        }
        while(lenB > lenA){
            curB = curB.next;
            lenB--;
        }
        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }


    public static ListNode newStart(ListNode cur, ListNode originalHead, int shortLen){
        ListNode comp = null;
        int longLen = shortLen;
        while(cur != null){
            longLen++;
            cur = cur.next;
        }
        int dif = longLen - shortLen;
        comp = originalHead;
        while(dif>=1){
            comp = comp.next;
            dif--;
        }
        return comp;
    }

    public static ListNode solution4(ListNode headA, ListNode headB){
        ListNode curA = headA, curB = headB;
        int shortLen = 0;
        while(curA != null && curB!= null){
            if(curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
            shortLen++;
        }
//      if listA.length == listB.length;
        if(curA == null && curB == null) return null;

//        if listA.length != listB.length, should align them -> cut the longer one's nodes
        ListNode compA = null, compB = null;
        if(curB != null){
            compB = newStart(curB, headB, shortLen);
            compA = headA;
        }
        if(curA != null){
            compA = newStart(curA, headA, shortLen);
            compB = headB;
        }

        while(compA != compB){
            compA = compA.next;
            compB = compB.next;
        }
        return compA;
    }

    public static void main(String[] args){
        {
            ListNode c3 = new ListNode(5);
            ListNode c2 = new ListNode(4, c3);
            ListNode c1 = new ListNode(8, c2);

            ListNode a2 = new ListNode(1, c1);
            ListNode a1 = new ListNode(4, a2);

            ListNode b3 = new ListNode(1, c1);
            ListNode b2 = new ListNode(6, b3);
            ListNode b1 = new ListNode(5, b2);

            ListNode r = solution4(a1, b1);
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();

        }

    }
}