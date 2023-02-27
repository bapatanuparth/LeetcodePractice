package leetcodeLL;


//Given the head of a linked list, rotate the list to the right by k places.
public class RotateLL {

//	Input: head = [1,2,3,4,5], k = 2
//	Output: [4,5,1,2,3]	
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        
        //find total number of nodes in LL
        int n=1;
        ListNode curr=head;
        while(curr.next!=null){
            n++;
            curr=curr.next;
        }
        ListNode tail=curr;
        
        //if k is multiple of n or ==n, rotations will be equal to initial state
        if(k%n==0 || k==0)return head;
        //if k>n, rotations will be equal to k%n
        if(k>n)k=k%n;
        
        int i=0;
        curr=head;
        //find the node previous to the node where rotation starts and make its next as null, 
        while(i<n-k-1){
            i++;
            curr=curr.next;
        }
        ListNode temp=curr.next;
        curr.next=null;
        //join the tail to head 
        tail.next=head;
       //return new head
        return temp;
            
    }
}
