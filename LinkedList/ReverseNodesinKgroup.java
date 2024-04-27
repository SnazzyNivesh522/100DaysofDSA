/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodesinKgroup {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        int cnt=0;
        while(curr!=null && cnt!=k){
            curr=curr.next;
            cnt++;
        }
        if(cnt==k){
            curr=reverseKGroup(curr,k);
            
            while(cnt-->0){
                ListNode temp=head.next;
                head.next=curr;
                curr=head;
                head=temp;
            }
            head=curr;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));        
        printList(node1);
        ListNode ans=new ReverseNodesinKgroup().reverseKGroup(node1, 2);
        printList(ans);

        node1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));        
        printList(node1);
        ans=new ReverseNodesinKgroup().reverseKGroup(node1,  3);
        printList(ans);
    }
}
