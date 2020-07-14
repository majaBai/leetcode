/* 138. deep Copy List with Random Pointer
* A linked list is given such that each node contains an additional random pointer which
* could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes.
* Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where
* random pointer points to, or null if it does not point to any node.

* Constraints:

-10000 <= Node.val <= 10000
Node.random is null or pointing to a node in the linked list.
Number of Nodes will not exceed 1000.

Example 1:
* Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
* Example 2:
* Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
*
* Example 4:
Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.
* */


import java.util.HashMap;

public class CopyListWithRandomPointer{

    public static Node solution(Node head){
        if(head == null) return null;

//        insert clone into original list
        Node cur = head;
        while(cur != null){
            Node clone = new Node(cur.val);
            Node next = cur.next;
            cur.next = clone;
            clone.next = next;
            cur = next;
        }

//        fix clone's random
        cur = head;
        while(cur != null){
            cur.next.random = cur.random == null? null : cur.random.next;
            cur = cur.next.next;
        }

//        segregate clone list
        cur = head;
        Node cloneHead = new Node(0);
        Node pre = cloneHead;
        while(cur != null){
            Node next = cur.next.next;
            pre.next = cur.next;
            pre = pre.next;

//          restore the original list
            cur.next = next;

            cur = cur.next;
        }
        return cloneHead.next;
    }

    public static Node solution2(Node head){
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        Node curNode = head;

        while(curNode != null){
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }

        curNode = head;

        while(curNode != null){
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }

        return map.get(head);
    }
    public static void main(String[] args){

    }
}