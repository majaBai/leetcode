public class RemoveListElements{

    public static ListNode solution(ListNode head, int val){
        if(head == null) return null;
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args){
        {
            ListNode n1 = new ListNode(1);
            int val = 1;
            ListNode r = solution(n1, val);
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }

    }
}