/*
You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
 */
public class RemoveNodesFromLL {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }        
    }
    static void printList(ListNode head) {
        while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
        }
        System.out.println();
    }
    // public ListNode removeNodes(ListNode head) {
    //     Stack<ListNode> stack =new Stack<>();
    //     ListNode curr=head;
    //     while(curr!=null){
    //         stack.push(curr);
    //         curr=curr.next;
    //     }
    //     curr=stack.pop();
    //     int maxval=curr.val;
    //     ListNode result=new ListNode(maxval);
    //     while(!stack.isEmpty()){
    //         curr=stack.pop();
    //         if(curr.val>=maxval){
    //             ListNode node=new ListNode(curr.val);
    //             node.next=result;
    //             result=node;
    //             maxval=curr.val;
    //         } 
    //     }
    //     return result;
        
    // }
    public ListNode removeNodes(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode nextNode=removeNodes(head.next);
        if(head.val<nextNode.val){
            return nextNode;
        }
        head.next=nextNode;
        return head;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(5, new ListNode(2, new ListNode(13,new ListNode(3,new ListNode(8)))));
        printList(node);
        ListNode result=new RemoveNodesFromLL().removeNodes(node);
        printList(result);

        node=new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1))));
        printList(node);
        result=new RemoveNodesFromLL().removeNodes(node);
        printList(result);
    }
}
