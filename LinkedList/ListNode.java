public class ListNode {    
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
    }
    public ListNode arrayToList(int[] arr) {
      ListNode head = null;  // Initialize head as null for an empty list

      for (int value : arr) {
          ListNode newNode = new ListNode(value,null);  // Create a new node for each element
          if (head == null) {
              head = newNode;  // Set head for the first element
          } else {
              // Traverse to the last node and link the new node
              ListNode current = head;
              while (current.next != null) {
                  current = current.next;
              }
              current.next = newNode;
          }
      }

      return head;
    }
}
