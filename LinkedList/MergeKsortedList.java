public class MergeKsortedList {
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
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    private static ListNode mergeSortApproach(ListNode []lists,int low,int high){
        if(low==high) return lists[low];
        if(low>high) return null;
        int mid=low+((high-low)/2);
        ListNode left=mergeSortApproach(lists,low,mid);
        ListNode right=mergeSortApproach(lists,mid+1,high);
        return mergeTwoLists(left,right);
    }
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length==0){
            return null;
        }
        return mergeSortApproach(lists,0,lists.length-1);
    }
    public static void main(String[] args) {
        MergeKsortedList mkl=new MergeKsortedList();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head3 = new ListNode(2, new ListNode(6));
        ListNode listNode[]=new ListNode[]{head1,head2,head3};
        System.out.println("Mergin three lists result in: ");
        ListNode result=mkl.mergeKLists(listNode);
        printList(result);
    }


    // //brute force
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode dummy=new ListNode(0);
    //     ListNode temp=dummy;
    //     while(true){
    //         ListNode ptr=null;
    //         int index=-1;
    //         for(int i=0;i<lists.length;i++){
    //             ListNode curr=lists[i];
    //             if(curr==null) continue;
    //             if(ptr==null || curr.val<=ptr.val){
    //                 ptr=curr;
    //                 index=i;
    //             }
    //         }
    //         if(ptr==null) break;

    //         temp.next=ptr;
    //         temp=temp.next;
    //         lists[index]=ptr.next;
    //     }
    //     return dummy.next;        
    // }

    
}
