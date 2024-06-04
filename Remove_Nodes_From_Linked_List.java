import java.util.Stack;

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
class Remove_Nodes_From_Linked_List {
       public ListNode removeNodes(ListNode head) {
              Stack<ListNode> stack = new Stack<>();
              ListNode curr = head;
              while (curr != null) {
                     stack.push(curr);
                     curr = curr.next;
              }
              curr = stack.pop();
              int maxval = curr.val;
              ListNode result = new ListNode(maxval);
              while (!stack.isEmpty()) {
                     curr = stack.pop();
                     if (curr.val >= maxval) {
                            ListNode node = new ListNode(curr.val);
                            node.next = result;
                            result = node;
                            maxval = curr.val;
                     }
              }
              return result;

       }
}