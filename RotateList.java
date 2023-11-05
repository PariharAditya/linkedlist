public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int length = 1;

        while(current.next != null) {
            current = current.next;
            length++; 
        }
        current.next = head;

        int rotation = k % length;
        int skip = length - rotation;
        ListNode newCurrent = head;

        for(int i = 0; i < skip-1; i++) {
            newCurrent = newCurrent.next;
        }
        head = newCurrent.next;
        newCurrent.next = null;

        return head;        
    }
}
