import java.util.Hashtable;

public class ReorderList{

    public static int getLength(ListNode head){
        ListNode cur = head;
        int l = 0;
        while(cur != null){
            l++;
            cur = cur.next;
        }
        return l;
    }

    public static void solution(ListNode head){
        if(head == null || head.next == null) return;
        int m = getLength(head);
        ListNode cur = head;
        Hashtable<Integer, ListNode> ht = new Hashtable<>(m);
        int i = 1;
        while(cur != null){
            ht.put(i++, cur);
            cur = cur.next;
        }
        int j = 1;
        int k = m;
        int mid = m % 2 == 0? m/2 : (m + 1)/2;
        while(j <= m/2){
            ListNode before = ht.get(j);
            ListNode after = ht.get(k);
            before.next = after;
            if(j + 1 <= mid) after.next = ht.get(j+1);
            j++;
            k--;
        }
        int tail = m % 2 != 0? (m+1)/2 : m/2 + 1;
         ht.get(tail).next = null;
    }

    public static void main(String[] args){
        {
            ListNode n5 = new ListNode(5);
            ListNode n4 = new ListNode(4, n5);
            ListNode n3 = new ListNode(3, n4);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);

            solution(n1);
            ListNode r = n1;
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
        {
            ListNode n4 = new ListNode(4);
            ListNode n3 = new ListNode(3, n4);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);

            solution(n1);
            ListNode r = n1;
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

    }
}