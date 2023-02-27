package leetCodeArrays2;
import java.util.*;

public class FindMostCompetitiveSubseq {

	 public int[] mostCompetitive(int[] nums, int k) {
	        
	        Stack<Integer> st= new Stack<>();
	        int n=nums.length;
	        
	        int[] res=new int[k];
	        
	        for(int i=0;i<nums.length;i++){
	            
	            while(!st.isEmpty() && st.size()-1+n-i>=k && st.peek()>nums[i])
	                st.pop();
	            st.push(nums[i]);
	        }
	        
	        while(st.size()>k){
	            st.pop();
	        }
	        
	        int i=k-1;
	        while(i>=0 && st.size()>0){
	            res[i]=st.pop();
	            i--;
	        }
	        return res;
	    
	    }
}
