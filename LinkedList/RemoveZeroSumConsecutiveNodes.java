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
/*
 Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
 */
import  java.util.HashMap;
class RemoveZeroSumConsecutiveNodes {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode zero=new ListNode(0,head);
        ListNode ptr=zero;
        int sum=0;
        HashMap<Integer,ListNode> sumMap=new HashMap<>();
        while(ptr!=null){
            sum+=ptr.val;
            if(sumMap.containsKey(sum)){
                sumMap.remove(sum);
            }
            sumMap.put(sum,ptr);                                            
            ptr=ptr.next;
        }
        sum=0;
        ptr=zero;
        while(ptr!=null){
            sum+=ptr.val;
            if(sumMap.containsKey(sum)){
                ListNode temp=sumMap.get(sum);
                ptr.next=temp.next;                
            }
            ptr=ptr.next;            
        }        
        return zero.next;
    }
    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodes rzscn= new RemoveZeroSumConsecutiveNodes();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(-1);
        l1.next=l2;
        System.out.println("List: -1->1");
        ListNode head=rzscn.removeZeroSumSublists(l1);
        System.out.print("Resulting list:");
        while(head!=null){
            System.out.println(head.val+"->");
            head=head.next;
        }

    }
    
}