// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 
public class MergeSortedList {
  
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1=list1;
        ListNode head2=list2;
        if(head1==null) return head2;
        else if(head2==null) return head1;
        ListNode curr=new ListNode(0);
        ListNode newHead=curr;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                curr.next=head1;
                head1=head1.next;
            }
            else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        if(head1!=null){
            curr.next=head1;
        }
        if(head2!=null){
            curr.next=head2;
        }
        return newHead.next;
        
    }
    public static void main(String[] args) {

        MergeSortedList solution = new MergeSortedList();
    
        // Test case 1: Both lists with elements
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedHead = solution.mergeTwoLists(head1, head2);
        System.out.println("Merged list for 1->2->4 and 1->3->4");
        printList(mergedHead); // Output: 1, 1, 2, 3, 4, 4
    
        // Test case 2: Empty lists
        head1 = null;
        head2 = null;
        mergedHead = solution.mergeTwoLists(head1, head2);
        System.out.println("Merged list for two empty list is:");
        printList(mergedHead); // Output: (empty list)
    
        // Test case 3: One empty list
        head1 = new ListNode(1);
        head2 = null;
        mergedHead = solution.mergeTwoLists(head1, head2);
        System.out.println("Merged list for 1->null and  empty list is:");
        printList(mergedHead); // Output: 1
    
      }
    
      public static void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
      }
    
}
