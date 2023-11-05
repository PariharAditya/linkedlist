/**
 * Removeduplicate
 */
public class Removeduplicate {
    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int data, ListNode next) {
            this.val = data;
            this.next = next;
        }

        public ListNode(int data) {
            this.val = data;
        }

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode IteratingNode = head;

        while (IteratingNode != null) {
            if (IteratingNode.next != null && IteratingNode.val == IteratingNode.next.val) {
                IteratingNode.next = IteratingNode.next.next;                
            } else {
                IteratingNode = IteratingNode.next;
            }
        }
        return head;
        
    }

    public static void main(String[] args) {
                
    }

}