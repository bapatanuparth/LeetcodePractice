package leetcodeLL;

public class InsertionSortLinkedList {

	   public static ListNode insertionSortList(ListNode head) {
	        if(head==null || head.next==null)return head;
	        
	        ListNode i=head,j=head.next;
	        while(j!=null){
	            ListNode temp=head;
	            if(temp.val>j.val){
	                int a=temp.val;
	                temp.val=j.val;
	                j.val=a;
	                continue;
	            }
	            while(temp.next.val<j.val){
	                temp=temp.next;
	                if(temp==j){
	                j=j.next;
	                break;
	                }
	            }
	             if(temp.next!=j){
	                 
	            	 	ListNode v=head;
	                    while(v.next!=j) {
	    	     			v=v.next;
	    	     		}
	                    
	                    ListNode x=temp.next;
	                    ListNode y=j.next;
	                    temp.next=j;
	                    j.next=x;
	                    v.next=y;
	         
	             
	                }
	            else if(temp.next==j)j=j.next;
	             ListNode v=head;
	             while(v!=null) {
	     			System.out.print (v.val);
	     			v=v.next;
	     		}
	        }
	        return head;
	    }
	   
	   public static void main(String[] args) {
		   ListNode head=new ListNode(-1);
		   head.next=new ListNode(5);
		   head.next.next=new ListNode(3);
		   head.next.next.next=new ListNode(4);
		   head.next.next.next.next=new ListNode(0);
		ListNode v=insertionSortList(head);
		while(v!=null) {
			System.out.println(v.val);
			v=v.next;
		}
	}
}
