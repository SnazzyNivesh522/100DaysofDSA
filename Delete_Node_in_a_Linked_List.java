/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        ListNode curr = node.next;
        node.next = node.next.next;
        node.val = curr.val;
    }
}