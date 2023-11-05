public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid  = middleNode(head);
        ListNode headFirst = head;
        ListNode headSecond = reverseList(mid);

        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }
        if (headFirst != null) {
            headFirst.next = null;
        }

    }

    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;        
    }

    private ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
}
