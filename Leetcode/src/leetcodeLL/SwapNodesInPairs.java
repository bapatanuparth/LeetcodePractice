package leetcodeLL;

//Given a linked list, swap every two adjacent nodes and return its head.
//		You must solve the problem without modifying the values in the list's 
//		nodes (i.e., only nodes themselves may be changed.)
//
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
public class SwapNodesInPairs {
	//java 100% fast solution
	 public ListNode swapPairs(ListNode head) {
	        if(head==null || head.next==null)return head;
	        ListNode prev=head;
	        ListNode curr=head, next=head.next;
	        boolean first=true;
	        while(curr!=null && curr.next!=null){
	            prev.next=curr.next;
	            curr.next=next.next;
	            next.next=curr;
	            prev=curr;
	            if(first){
	                head=next;
	                first=false;
	            }
	            curr=curr.next;
	            if(curr!=null)next=curr.next;
	        }
	        
	        return head;
	    }
}
