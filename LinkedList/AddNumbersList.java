// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

// Example 1:


// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
public class AddNumbersList {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode headResult=result;
        int carry=0,sum;//initially no carry and sum
        while(l1!=null || l2!=null){
            sum=0+carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            sum=sum%10;
            result.next=new ListNode(sum);
            result=result.next;
        }
        if(carry==1){
            result.next=new ListNode(1);
        }
        return headResult.next;
    
    }
    public static void main(String[] args) {
        AddNumbersList s= new AddNumbersList();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = s.addTwoNumbers(l1, l2);
        System.out.println("l1 = [2,4,3] + l2 = [5,6,4]");
        printList(result);
    }
    
}
