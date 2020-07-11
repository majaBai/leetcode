public class MergeKSortedList{

    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode r = new ListNode();
        ListNode res = r;
        while(l1 != null && l2 != null){
            if(l2.val < l1.val){
                res.next = l2;
                l2 = l2.next;
            } else{
                res.next = l1;
                l1 = l1.next;
            }
            res = res.next;
        }
        while(l1 != null){
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }
        while(l2 != null){
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }
        return r.next;
    }

    public static ListNode solution(ListNode[] lists){
        if(lists.length <= 1){
            return lists.length==1? lists[0] : null;
        }
        ListNode res = lists[0];
        for(int i = 1; i < lists.length;i++){
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }


    public static void main(String[] args){
//        {
//            ListNode n1 = new ListNode(6);
//            ListNode n2 = new ListNode(2, n1);
//
//            ListNode t1 = new ListNode(5);
//            ListNode t2 = new ListNode(4, t1);
//            ListNode t3 = new ListNode(2, t2);
//            ListNode t4 = new ListNode(1, t3);
//
//            ListNode d1 = new ListNode(9);
//            ListNode d2 = new ListNode(6, d1);
//
//            ListNode[] lists = {n2, t4, d2};
//
//            ListNode r = solution(lists);
//            while(r!=null){
//                System.out.print(r.val + " ");
//                r = r.next;
//            }
//            System.out.println();
//        }
//        {
//            ListNode n1 = new ListNode(6);
//            ListNode n2 = new ListNode(2, n1);
//
//            ListNode d1 = new ListNode(9);
//            ListNode d2 = new ListNode(6, d1);
//
//            ListNode[] lists = {n2, d2};
//
//            ListNode r = solution(lists);
//            while(r!=null){
//                System.out.print(r.val + " ");
//                r = r.next;
//            }
//            System.out.println();
//        }
//        {
//            ListNode[] lists = {};
//            ListNode r = solution(lists);
//            while(r!=null){
//                System.out.print(r.val + " ");
//                r = r.next;
//            }
//            System.out.println();
//        }
//        {
//            ListNode n1 = new ListNode(6);
//            ListNode n2 = new ListNode(2, n1);
//
//            ListNode[] lists = {n2};
//            ListNode r = solution(lists);
//            while(r!=null){
//                System.out.print(r.val + " ");
//                r = r.next;
//            }
//            System.out.println();
//        }
        {
            ListNode n1 = new ListNode();
            ListNode t1 = new ListNode();

            ListNode[] lists = {n1, t1};

            ListNode r = solution(lists);
            while(r!=null){
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
//        {
//            ListNode n1 = new ListNode(0);
//            ListNode t1 = new ListNode(0);
//
//            ListNode[] lists = {n1, t1};
//
//            ListNode r = solution(lists);
//            while(r!=null){
//                System.out.print(r.val + " ");
//                r = r.next;
//            }
//            System.out.println();
//        }

    }

}