package leetcodeLL;


//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
//leaving only distinct numbers from the original list. Return the linked list sorted as well.
//
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//
//Input: head = [1,1,1,2,3]				
//Output: [2,3]
public class RemoveDuplicatesPart2 {

	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode first=head;
        boolean flag=false;
        while(first!=null && first.next!=null){
            flag=false;
            //in middle elements, find duplicates and remove
            while(first.next!=null && first.next.val==first.val){
                flag=true;
                first.next=first.next.next;
            }
            if(flag){
            	//to handle corner cases where -->
            	// [1,1,1,1,1] ==> here we need to return null as all duplicates of head
            	
                if(first.next==null){
                    if(first==head)return null;
                    else{
                    	//[1,2,2,2,2,2] here, we need to reach the point before there are all duplicates
                    	//need to make next of this as null because we need to remove it
                        ListNode prev=head;
                        //find previous of where duplicates start and make its nxt==null
                        while(prev.next!=first)prev=prev.next;
                        prev.next=null;
                        return head;
                    }
                }
                //delete the present element to which the pointer is pointing as it was duplicate
                first.val=first.next.val;
                first.next=first.next.next;
                continue;
            }
            first=first.next;
        }
        
        return head;
    }
}
