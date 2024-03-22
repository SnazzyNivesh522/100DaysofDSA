

/*
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 */
/**
 * PalindromeLL
 */

public class PalindromeLinkedList {
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

    static ListNode reverseList(ListNode head) {
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow,fast;
        slow=fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if(fast!=null && fast.next!=null){
            slow=slow.next;
        }
        ListNode aftMidrev=reverseList(slow);
        ListNode start=head;
        while(start!=null && aftMidrev!=null){
            if(start.val!=aftMidrev.val){
                return false;
            } 
            start=start.next;
            aftMidrev=aftMidrev.next;
        }
        return true;

        
        
    }
    public static void main(String[] args) {
        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("Original list");
        printList(head);

        System.out.println(obj.isPalindrome(head));

    }
    
}