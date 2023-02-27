package leetcodeLL;
import java.util.*;

public class PalindromeLL {

	
	//naive solution using O(n) extra space
	  public boolean isPalindrome(ListNode head) {
	        if(head==null)return false;
	        ListNode mid=head, fast=head;
	        List<Integer> alist=new ArrayList<>();
	        while(fast!=null && fast.next!=null){
	            alist.add(mid.val);
	            mid=mid.next;
	            fast=fast.next.next;
	        }
	        //case when n is even
	        if(fast==null){
	            int i=alist.size()-1;
	            while(mid!=null){
	               
	                if(mid.val!=alist.get(i))return false;
	                mid=mid.next;
	                i--;
	            }
	             return true;
	        }
	       //case when n is odd
	        else if(fast.next==null){
	                int i=alist.size()-1;
	                mid=mid.next;
	                while(mid!=null){
	                if(mid.val!=alist.get(i))return false;
	                    mid=mid.next;
	                i--;
	            }
	            
	        }
	          return true;
	        
	    }
}
