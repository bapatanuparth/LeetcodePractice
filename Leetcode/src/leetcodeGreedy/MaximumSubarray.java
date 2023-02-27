package leetcodeGreedy;

public class MaximumSubarray {

	 public int maxSubArray(int[] nums) {
	        int curr_max=nums[0];
	        int max_so_far=nums[0];
	        
	        for(int i=1;i<nums.length;i++){
	            curr_max= Math.max(nums[i]+curr_max, nums[i]); //either consider subarray with past elements or just take the current element
	            max_so_far= Math.max(max_so_far, curr_max);
	        }
	        
	        return max_so_far;
	    }
}
