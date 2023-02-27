package leetCodeArrays;
import java.util.*;


//Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
//
//A subarray is a contiguous part of an array.

//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
public class SubarraySumDivisibleByK {

	//Efficient code using Hashmap
	//store prefixsum % k in map with number of times it occurs
	//when we see the same value of prefixsum % k again, it means the array in the middle has the sum==k
	
	public int subarraysDivByKEff(int[] nums, int k) {
	      
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        //map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
          
            int temp=sum%k;
            if(temp<0)temp=temp+k;
      
            if(temp==0)count++;
            if(map.containsKey(temp))
            {
                count+=map.get(temp);
                map.replace(temp,map.get(temp)+1);
            } 
            else
                map.put(temp,1);
        }
        
        
        
        return count;
        
        
    }
	
	//gives time limit exceeded because of the double for loop
	 public int subarraysDivByK(int[] nums, int k) {
	        int [] presum=new int[nums.length];
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            presum[i]=sum;
	        }
	        
	        int count=0;
	        
	        for(int i=0;i<presum.length;i++){
	            
	            int temp=presum[i];
	            if(temp%k==0)count++;
	                
	            for(int j=0;j<i;j++){
	                int c=temp-presum[j];
	                if(c%k==0)count++;   
	            }
	        }
	        
	        return count;
	        
	        
	    }
}
