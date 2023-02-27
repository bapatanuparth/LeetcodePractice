package leetcodeLL;

//In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
//
//For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
//The twin sum is defined as the sum of a node and its twin.
//
//Given the head of a linked list with even length, return the maximum twin sum of the linked list.
public class MaximumTwinSumLL {

	
	//n will always be even
	 public int pairSum(ListNode head) {
		 //finding a node previous to the mid point
	        ListNode mid=head,fast=head;
	        fast=head.next;
	        while(fast.next!=null){
	            mid=mid.next;
	            fast=fast.next.next;
	        }
	        //now, reverse the linked list from mid.next to the end of LL
	        ListNode curr=mid.next, prev=mid.next,next=curr.next;
	        while(curr.next!=null){
	            ListNode temp=next.next;
	            next.next=prev;
	            curr.next=temp;
	            prev=next;
	            next=curr.next;   
	        }
	        //point mid.next to the changed head of LL after the reverse operation
	        mid.next=prev;
	        mid=mid.next;
	        //calculate sum of twins using 2 pointers, head and mid
	        int sum=Integer.MIN_VALUE;
	        while(mid!=null){
	            sum=Math.max(sum,head.val+mid.val);
	            head=head.next;
	            mid=mid.next;
	        }  
	       //return max
	        return sum;  
	    }
}
