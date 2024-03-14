/*
 Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */

/*
 Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
 */
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