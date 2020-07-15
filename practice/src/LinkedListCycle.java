/*
* Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents
* the position (0-indexed) in the linked list where tail connects to.
* If pos is -1, then there is no cycle in the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
*
* */

import java.util.HashSet;
import java.util.List;

public class LinkedListCycle{

//    time complexity: O(n), use cur to iterate the whole list(if no cycle)
//    space complexity: O(n) , use set to save all node(if no cycle)
    public static boolean solution1(ListNode head){
        HashSet<ListNode> set = new HashSet();
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur)){
                return true;
            } else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }

//    time complexity: O(N + K) =>
//    The slow pointer takes "non-cyclic length N" steps to enter the cycle.
//    At this point, the fast pointer has already reached the cycle;
//    Both pointers are now in the cycle. it takes K loops for the fast runner to catch up with the slow runner.
//    K == distance between the 2 runners / two pointer's speed difference == cyclic length  / 1 == cyclic length
//    space complexity: O(1)

    public static boolean solution2(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }



    public static void main(String[] args){

    }
}