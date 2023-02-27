package leetCodeArrays2;
//monotonic stack -- leetcode 456 watch youtube video
import java.util.*;

//veery tricky 
public class Pattern132 {
	
	//we wnt to find pattern i < j < k
	//k we will maintain in stack
	//i we will keep in min[] --> i will be the value of minimum element till given index
	//j we will check one by one if its lying between min till now and if its > stack.peek
	 public boolean find132pattern(int[] nums) {
	        if(nums.length<3)return false;
	        
	        int min[] = new int[nums.length];
	        min[0]= nums[0];
	        for(int i=1;i<nums.length;i++){
	            min[i]= Math.min(min[i-1],nums[i]);
	        }
	        Stack<Integer> st= new Stack<>();
	        
	        for(int j=nums.length-1;j>=0;j--){
	            
	                while(!st.isEmpty() && st.peek()<=min[j]) //check if top of stack > minimum value till now
	                    st.pop(); //if top < min till now -- remove from stack
	                
	                if(!st.isEmpty() && st.peek()<nums[j]) //if we find that jth val > st.peek , it means 1 3 2 pattern is found
	                    return true; //stack .peek will have k, min value will be i and if j> k it means we have found  i j k such that 1 3 2 pattern present
	            st.push(nums[j]);
	        }
	        return false;
	    }

}
