package leetCodeArrays;
//
//You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
//
//Return the sum of all subarray ranges of nums.
//
//A subarray is a contiguous non-empty sequence of elements within an array.

//Input: nums = [1,2,3]
//Output: 4

public class SumOfSubarrayRanges {

	 public long subArrayRanges(int[] nums) {
	        long sum=0;
	        //get the max/min of a certain subarray by using the max/min of a smaller subarray within it
//	        Notice that the max of the subarray from index i to j is equal to max of (max of the subarray from index i to j-1) and nums[j].
	        for(int i=0;i<nums.length-1;i++){
	            
	            int max=nums[i],min=nums[i];
	            for(int j=i+1;j<nums.length;j++){
	                max=Math.max(max,nums[j]);
	                min=Math.min(min,nums[j]);
	                sum+=max-min;
	            }
	        }
	        
	        return sum;
	    }
}
