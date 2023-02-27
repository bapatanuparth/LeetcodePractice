package leetcodeLL;

public class MergeTwoSortedLL {

	 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode a=list1, b=list2;
	        if(a==null && b==null)return null;
	        if(a==null)return b;
	        if(b==null)return a;
	        ListNode head= (a.val<=b.val)?a:b;
	        while(a!=null && b!=null){
	            if(a.val<=b.val){
	                System.out.println("true");
	                while(a.next!=null && a.next.val<=b.val)a=a.next;
	                ListNode temp1=a.next;
	                a.next=b;
	                a=temp1;
	            }else{
	                
	                while(b.next!=null && b.next.val<a.val)b=b.next;
	                ListNode temp2=b.next;
	                System.out.println(b.val);
	                b.next=a;
	                b=temp2;
	            }
	        }
	        return head;
	    }
}
