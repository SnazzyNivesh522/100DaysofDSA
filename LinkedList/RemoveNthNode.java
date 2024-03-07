public class RemoveNthNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        //floyd tortoise and hare
        //making difference of n in fast and slow
        
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null) return slow.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
        
    }
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // Test case 1: Remove the second node from the end (n = 2)
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result1 = new RemoveNthNode().removeNthFromEnd(head1, 2);
        System.out.println("Test case 1:");
        printList(result1); // Expected output: 1 -> 2 -> 4

        // Test case 2: Remove the head node (n = 1)
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result2 = new RemoveNthNode().removeNthFromEnd(head2, 1);
        System.out.println("Test case 2:");
        printList(result2); // Expected output: 2 -> 3

        // Test case 3: Remove the last node (n = list length)
        ListNode head3 = new ListNode(1);
        ListNode result3 = new RemoveNthNode().removeNthFromEnd(head3, 1);
        System.out.println("Test case 3:");
        printList(result3); // Expected output: null

        // Test case 4: Empty list (n is irrelevant)
        ListNode head4 = null;
        ListNode result4 = new RemoveNthNode().removeNthFromEnd(head4, 1);
        System.out.println("Test case 4:");
        printList(result4); // Expected output: null

        // Test case 5: n greater than list length (remove head)
        ListNode head5 = new ListNode(1, new ListNode(2));
        ListNode result5 = new RemoveNthNode().removeNthFromEnd(head5, 2);
        System.out.println("Test case 5:");
        printList(result5); // Expected output: 2
    }

    
    
}
