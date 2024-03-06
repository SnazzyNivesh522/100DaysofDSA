public class CycleDetection{    
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }        
    }
    public boolean hasCycle(ListNode head) {
        //floyds tortoise and hare
        //fast and slow pointer
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        do{
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }

        }while (fast!=null && fast.next!=null);
        return false;

        
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if(head==head.next){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                fast=head;
                while(true){
                    if(fast==slow) 
                        return fast;
                    slow=slow.next;
                    fast=fast.next;
                }
            }
        }
        return null;
        
    }    
    public static void main(String[] args) {
        CycleDetection obj=new CycleDetection();
        // Create the linked list nodes
        
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Connect the nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // the cycle

        if (obj.hasCycle(node1)){
            System.out.println("Cycle detected!");
        } 
        else{
            System.out.println("No cycle found.");
        }

        ListNode cycleStart = obj.detectCycle(node1);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle found.");
        }
    }

    
}