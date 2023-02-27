package leetCodeArrays;
import java.util.*;

public class ContinuousSubArraySum {

	  public boolean checkSubarraySum(int[] nums, int k) {
	        //for k=0,only two or more consecutive 0's were possible
	        if(k == 0){
	            return false;
	        }
	        
	        //if length is less than 2 then return false
	        if(nums.length < 2){
	            return false;
	        }
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        
	        int curr_sum = 0;
	        
	        for(int i = 0; i<nums.length; i++){
	            curr_sum += nums[i];
	            
	            //if subarray starting fron index 0 is a multiple of k
	            if(curr_sum%k == 0 && i > 0){
	                return true;
	            }
	            if(map.containsKey(curr_sum%k)){
	                //check whether the size of subarray is more than 1
	                if(i - map.get(curr_sum % k) >= 2){ 
	                    return true;
	                }
	            }else{
	                map.put(curr_sum % k, i);
	            }
	        }
	        return false;
	    }
}
