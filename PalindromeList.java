public class PalindromeList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(ListNode head) {
     ListNode mid = getMid(head);
     ListNode secondHalf = reverseList(mid);
     ListNode reReversed = secondHalf;

     while (head != null && secondHalf != null) {
        if (head.val != secondHalf.val) {
            break;
        }
        head = head.next;
        secondHalf = secondHalf.next;
     }
     reverseList(reReversed);
     
     return head == null || secondHalf == null;     
    }
    //using fast and slow pointer
    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;        
    }

    public ListNode reverseList(ListNode head) {
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
