public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
       
    public static void main(String[] args) {
        
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;     
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeList(left, right);   
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                list1.next = mergeList(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeList(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null) {
            return list2;
        }
        return list1;

    }

    public ListNode getMid(ListNode head) {
        ListNode midPrev = null;

        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head: midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;

        return mid;
    }
}
