/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode current=head;

        while(current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return head;        
    }
    public static void main(String[] args) {
        RemoveDuplicatesSortedList rdsl = new RemoveDuplicatesSortedList();

        // Test Case 1:
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println("Test Case 1:");
        System.out.print("Original list: ");
        printList(head1);
        head1 = rdsl.deleteDuplicates(head1);
        System.out.print("List after removing duplicates: ");
        printList(head1);

        // Test Case 2:
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4))));
        System.out.println("\nTest Case 2:");
        System.out.print("Original list: ");
        printList(head2);
        head2 = rdsl.deleteDuplicates(head2);
        System.out.print("List after removing duplicates: ");
        printList(head2);
    }
    
}
