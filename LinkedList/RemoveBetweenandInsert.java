/*
You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure indicate the result:


Build the result list and return its head.

 

Example 1:


Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
Example 2:


Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.
 */
/**
 * RemoveBetweenandInsert
 */
public class RemoveBetweenandInsert {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        b=b-a;
        ListNode temp=list1;
        ListNode temp2=list2;
        while(temp2.next!=null){
            temp2=temp2.next;
        }
        while(a>1){
            temp=temp.next;
            a--;
        }
        ListNode t=temp;
        temp=temp.next;
        t.next=list2;
        while(b>0){
            b--;
            temp=temp.next;
        }
        temp2.next=temp.next;
        return list1;
        
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(13);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(5);
        System.out.println("List 1 :");
        printList(list1);

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        System.out.println("List 2 :");
        printList(list2);

        RemoveBetweenandInsert rbii = new RemoveBetweenandInsert();
        ListNode result = rbii.mergeInBetween(list1, 3, 4, list2);
        System.out.println("After Removing 3rd and 4th:");
        printList(result);
        
    }            
    
            
}