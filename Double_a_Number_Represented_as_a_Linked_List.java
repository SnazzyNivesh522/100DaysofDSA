/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Double_a_Number_Represented_as_a_Linked_List {
       private ListNode reverseList(ListNode head) {
              if (head == null)
                     return null;
              ListNode prev = null;
              ListNode current = head;
              ListNode nxt = current.next;
              while (nxt != null) {
                     current.next = prev;
                     prev = current;
                     current = nxt;
                     nxt = nxt.next;
              }
              current.next = prev;
              return current;
       }

       public ListNode doubleIt(ListNode head) {
              head = reverseList(head);
              ListNode curr = head;
              ListNode prev = null;
              int carry = 0;
              while (curr != null) {
                     int num = curr.val * 2 + carry;
                     curr.val = num % 10;
                     if (num > 9)
                            carry = 1;
                     else
                            carry = 0;
                     prev = curr;
                     curr = curr.next;
              }
              if (carry > 0) {
                     prev.next = new ListNode(carry);
              }
              ListNode doubled = reverseList(head);
              return doubled;
       }
}