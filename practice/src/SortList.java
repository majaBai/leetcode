import java.util.List;
/*
* Sort a linked list in O(n log n) time using constant space complexity.
* */
public class SortList {

    public static int getLengthOfList(ListNode head){
        int len = 0;
        while(head != null){
            len +=1;
            head = head.next;
        }
        return len;
    }

    public static ListNode splitList(ListNode n, int step){
        while(0 < --step){
            n = n.next;
        }
        ListNode mid = n.next;
        n.next = null;
        return mid;
    }

    public static ListNode sortList(ListNode head){
        int len = getLengthOfList(head);
        return sortList(head, len);
    }

    public static ListNode sortList(ListNode head, int len){
        if(len <= 1) return head;

        ListNode mid = splitList(head, len/2);

        ListNode list1 = sortList(head, len/2);
        ListNode list2 = sortList(mid, len -len/2);
        return merge_list(list1, list2);
    }

    public static ListNode merge_list(ListNode list1, ListNode list2){
        ListNode mergedList = new ListNode();
        ListNode mergeHead = mergedList;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                mergeHead.next = list1;
                list1 = list1.next;
            } else {
                mergeHead.next = list2;
                list2 = list2.next;
            }
            mergeHead = mergeHead.next;
        }
        if(list1 != null){
            mergeHead.next = list1;
        }
        if(list2 != null){
            mergeHead.next = list2;
        }
        return mergedList.next;
    }

    public static void main(String[] args){
        ListNode d = new ListNode(3);
        ListNode c = new ListNode(1, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(4, b);
        ListNode r = sortList(a);
        while(r != null){
            System.out.print(r.val + " ");
            r = r.next;
        }
    }
}