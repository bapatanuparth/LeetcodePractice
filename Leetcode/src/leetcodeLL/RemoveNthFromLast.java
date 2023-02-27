package leetcodeLL;

//Given the head of a linked list, remove the nth node from the end of the list and
//return its head.
public class RemoveNthFromLast {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head, fast=head;
        while(--n>=0){
            fast=fast.next;
        }
        if(fast==null){
            return slow.next;
        };
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
