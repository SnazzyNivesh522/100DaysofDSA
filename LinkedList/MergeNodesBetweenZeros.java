/*
You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

 

Example 1:


Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.
Example 2:


Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.
 */
public class MergeNodesBetweenZeros extends ListNode{
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        ListNode zero = head;
        ListNode prev=head;
        while (curr.next != null) {
            prev=zero;
            if (curr.next.val == 0) {
                zero.next = curr.next;
                zero = curr.next;
            } 
            else {
                zero.val += curr.next.val;
            }
            
            curr = curr.next;
        }
        prev.next=null;
        curr=null;
        zero=null;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        
        MergeNodesBetweenZeros mnbz = new MergeNodesBetweenZeros();
        ListNode result = mnbz.mergeNodes(head);
        mnbz.printList(result);

        head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        
        result = mnbz.mergeNodes(head);
        mnbz.printList(result);
    }
}
