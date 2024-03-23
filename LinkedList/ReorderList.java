public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    static void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhalf=slow.next;
        ListNode prev=null;
        slow.next=null;
        // reversing second half
        while(secondhalf!=null){
            ListNode temp=secondhalf.next;
            secondhalf.next=prev;
            prev=secondhalf;
            secondhalf=temp;
        }
        // merge the first and reversed seond half
        ListNode first=head;
        secondhalf=prev;
        while(secondhalf!=null){
            ListNode temp1=first.next;
            ListNode temp2=secondhalf.next;
            first.next=secondhalf;
            secondhalf.next=temp1;
            first=temp1;
            secondhalf=temp2;
        }        
    }
    public static void main(String[] args) {
        ReorderList rl=new ReorderList();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null; 
        System.out.println("Original list");
        printList(head);

        rl.reorderList(head);
        System.out.println("Reordered list");
        printList(head);
    }

    
}