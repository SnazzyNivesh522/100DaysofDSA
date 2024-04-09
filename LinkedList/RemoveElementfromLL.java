/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
 */
public class RemoveElementfromLL {
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        while(head!=null && head.val==val ){
            head=head.next;
        }
        if(head==null) return null;
        ListNode current=head;

        while(current.next!=null){
            if(val==current.next.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return head;
        
    }
    public static void main(String[] args) {
        RemoveElementfromLL rdsl = new RemoveElementfromLL();

        // Test Case 1:
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4,new ListNode(5,new ListNode(6, null)))))));
        System.out.println("Test Case 1:");
        System.out.print("Original list: ");
        printList(head1);
        head1 = rdsl.removeElements(head1,6);
        System.out.print("List after removing duplicates: ");
        printList(head1);

        // Test Case 2:
        ListNode head2 = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        System.out.println("\nTest Case 2:");
        System.out.print("Original list: ");
        printList(head2);
        head2 = rdsl.removeElements(head2,7);
        System.out.print("List after removing duplicates: ");
        printList(head2);
    }
}
