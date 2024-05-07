/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:


Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
 */
public class DoubleNumberRepresentedByLL {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }        
    }
    static void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
    }
    //we are doubling so we can carry will be there if val at next node is >4
    public ListNode doubleIt(ListNode head){
        if(head.val>4){
            head=new ListNode(0,head);
        }
        ListNode curr=head;
        while(curr!=null){
            curr.val= (curr.val * 2) % 10;
            if(curr.next!=null && curr.next.val>4){
                curr.val++;
            }
            curr=curr.next;
        }
        return head;
    }
    // private ListNode reverseList(ListNode head) {
    //     if(head==null) return null;
    //     ListNode prev=null;
    //     ListNode current=head;
    //     ListNode nxt=current.next;
    //     while(nxt!=null){
    //         current.next=prev;
    //         prev=current;
    //         current=nxt;
    //         nxt=nxt.next;
    //     }
    //     current.next=prev;    
    //     return current;
    // }
    // public ListNode doubleIt(ListNode head) {
    //     head=reverseList(head);
    //     ListNode curr=head;
    //     ListNode prev=null;
    //     int carry=0;
    //     while(curr!=null){
    //         int num=curr.val*2+carry;
    //         curr.val=num%10;
    //         if(num>9) carry=1;
    //         else carry=0;
    //         prev=curr;
    //         curr=curr.next;
    //     }
    //     if(carry==1){
    //         prev.next=new ListNode(carry);
    //     }
    //     ListNode doubled=reverseList(head);
    //     return doubled;
    // }
    public static void main(String[] args) {
        ListNode node=new ListNode(1,new ListNode(8,new ListNode(9)));
        printList(node);
        ListNode result=new DoubleNumberRepresentedByLL().doubleIt(node);
        printList(result);
        node=new ListNode(9,new ListNode(9,new ListNode(9)));
        printList(node);
        result=new DoubleNumberRepresentedByLL().doubleIt(node);
        printList(result);
    }
}
