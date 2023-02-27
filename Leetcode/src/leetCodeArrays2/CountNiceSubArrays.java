package leetCodeArrays2;

//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//
//Return the number of nice sub-arrays.

//Input: nums = [1,1,2,1,1], k = 3
//Output: 2

//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16
public class CountNiceSubArrays {

	//can convert the problem in to Binary Subarray with sum problem (Leetcode 930)
	 int helper(int [] nums, int k){
	       int res=0;
	        int sum=0;
	        int left=0;
	        
	        //convert the array to a binary array
	        for(int i=0;i<nums.length;i++){
	            nums[i]=nums[i]%2;
	        }
	        
	        
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
	    
	    
	    public int numberOfSubarrays(int[] nums, int k) {
	         
	        
	        return helper(nums,k)-helper(nums,k-1);
	        
	        
	    }
}
