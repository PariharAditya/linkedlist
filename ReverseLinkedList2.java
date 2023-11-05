public class ReverseLinkedList2 {
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

        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();

        // Test case 1: Reverse a sublist within the linked list
        ListNode head1 = reverseLinkedList2.new ListNode(1);
        ListNode node2 = reverseLinkedList2.new ListNode(2);
        ListNode node3 = reverseLinkedList2.new ListNode(3);
        ListNode node4 = reverseLinkedList2.new ListNode(4);
        ListNode node5 = reverseLinkedList2.new ListNode(5);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result1 = reverseLinkedList2.reverseBetween(head1, 2, 4);
        ListNode expected1 = reverseLinkedList2.new ListNode(1);
        ListNode expectedNode4 = reverseLinkedList2.new ListNode(4);
        ListNode expectedNode3 = reverseLinkedList2.new ListNode(3);
        ListNode expectedNode2 = reverseLinkedList2.new ListNode(2);
        ListNode expectedNode5 = reverseLinkedList2.new ListNode(5);
        expected1.next = expectedNode4;
        expectedNode4.next = expectedNode3;
        expectedNode3.next = expectedNode2;
        expectedNode2.next = expectedNode5;

        System.out.println("Test case 1:");
        printList(result1);
        System.out.println("Expected:");
        printList(expected1);

    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        // reversal of Nodes
        ListNode last = previous;
        ListNode newEnd = current;
        ListNode next = current.next;

        for (int i = 0; current != null && i < right - left + 1; i++) {
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
        return head;
    }
}
