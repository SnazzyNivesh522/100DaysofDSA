/**
 * ReversingLinkedList
 */
/*
 Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 */
public class ReversingLinkedList {
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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode prev=null;
        ListNode current=head;
        ListNode nxt=current.next;
        while(nxt!=null){
            current.next=prev;
            prev=current;
            current=nxt;
            nxt=nxt.next;
        }
        current.next=prev;    
        return current;

    }
    public static void main(String[] args) {
        ReversingLinkedList rll = new ReversingLinkedList();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Original list");
        printList(head);
        ListNode newhead=rll.reverseList(head);
        System.out.println("Reversed list");
        printList(newhead);
    }
}