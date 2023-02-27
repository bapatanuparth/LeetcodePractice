package leetcodeLL;


//reverse the linked list between 2 pointers left and right
//Given the head of a singly linked list and two integers left and right where left <= right,
//reverse the nodes of the list from position left to position right, and return the reversed list.

public class ReverseLinkedList2 {

	 public ListNode reverseBetween(ListNode head, int left, int right) {
	        ListNode curr=head, prev=head, next=head;
	        if(left==right)return head;
	        if(head==null || head.next==null)return head;
	        int n=1;
	        ListNode rev_head=head;
	        while(n<left){
	            if(n==left-1)rev_head=curr;
	            curr=curr.next;
	            n++;
	        }
	        prev=curr;
	        ListNode temp=curr;
	        curr=curr.next;
	        while(n<right){
	            next=curr.next;
	            curr.next=prev;
	            if(prev==temp)prev.next=null;
	            prev=curr;
	            curr=next;
	            n++;
	        }
	        temp.next=curr;
	        if(left!=1)rev_head.next=prev;
	        
	        return (left==1)?prev:head;
	    }
}
