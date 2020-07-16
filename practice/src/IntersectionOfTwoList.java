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

    public static void main(String[] args){

    }
}