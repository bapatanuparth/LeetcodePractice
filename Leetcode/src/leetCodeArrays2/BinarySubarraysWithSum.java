package leetCodeArrays2;
import java.util.*;

//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//
//A subarray is a contiguous part of the array.
public class BinarySubarraysWithSum {

	//veryyy efficient code MUST WATCH
	  int helper(int [] nums, int k){
	       int res=0;
	        int sum=0;
	        int left=0;
	        
	        for(int i=0;i<nums.length;i++){
	        
	            sum+=nums[i];
	        
	            while(left<=i && sum>k){
	                sum-=nums[left];
	                left++;
	            }
	            res+=i-left+1;
	        }
	        
	        return res;
	        
	    }
	    
	    public int numSubarraysWithSumEff(int[] nums, int k) {
	     
	        return helper(nums, k)- helper(nums ,k-1);
	        
	        
	    }
	
	
	
	    
	//approach num 2
	 public int numSubarraysWithSum(int[] nums, int k) {
	     	//count the number of times sum - k has occurred previously
		 //if it has occurred, it means the sub array between the previous point of occurrence to current point also has the 
		 //sum == k
		 	
	        Map<Integer, Integer> map= new HashMap<>();
	        map.put(0,1);
	        
	        int sum=0, res=0;
	        for(int a:nums){    
	            sum+=a;
	            
	            if(map.containsKey(sum-k))
	                res+=map.get(sum-k);
	            map.put(sum, map.getOrDefault(sum,0)+1);
	            
	        }
	        
	        return res;
	        
	        
	    }
}
