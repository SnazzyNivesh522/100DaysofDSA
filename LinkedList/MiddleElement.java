public class MiddleElement{
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }        
    }
    public ListNode middleNode(ListNode head) {
        //floyds tortoise and hare
        //using one pointer fast to travel 2x so slow is at half speed
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Find the middle element
        MiddleElement me = new MiddleElement();
        ListNode middleNode = me.middleNode(head);

        // Print the middle element
        if (middleNode != null) {
            System.out.println("The middle element is: " + middleNode.val);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}