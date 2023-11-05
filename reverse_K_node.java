public class reverse_K_node {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (true) {
            ListNode last = previous;
            ListNode newEnd = current;
            ListNode next = current.next;

            for (int i = 0; current != null && i < k; i++) {
                current.next = previous;
                previous = current;
                current = next;

                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = previous;
            } else {
                head = previous;
            }
            newEnd.next = current;

            if(current == null) break;

        }
        return head;
    }

}
