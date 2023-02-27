package leetcodeLL;

//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//
//The first node is considered odd, and the second node is even, and so on.
//
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.
public class OddEvenLinkedList {

	 public ListNode oddEvenList(ListNode head) {
	        if(head==null || head.next==null)return head;
	        ListNode odd=head, even=head.next;
	        ListNode evehead=even, oddhead=odd;
	        while(even!=null && even.next!=null){
	            ListNode nodd=even.next;
	            odd.next=nodd;
	            even.next=nodd.next;
	            odd=odd.next;
	            even=even.next;
	        }
	        odd.next=evehead;
	        return oddhead;
	    }
}
