package leetCodeArrays;


//Given an array of positive integers nums and a positive integer target, 
//return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than 
//or equal to target. If there is no such subarray, return 0 instead.

//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2		 
public class MinSumSubArray {

	//easier sliding window
	 public int minSubArrayLenEff(int target, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i];
        while (sum >= target) {	
            ans = Math.min(ans, i + 1 - left);
            sum -= nums[left++];
        }
    }
    return (ans != Integer.MAX_VALUE) ? ans : 0;
	 }
	
	//sliding window
	 public int minSubArrayLen(int target, int[] nums) {
	        int left=0,right=0;
	        int size=Integer.MAX_VALUE;
	        int sum=nums[0];
	        while(right<nums.length){
	            if(sum<target){
	                right++;
	                if(right==nums.length)break;
	                sum+=nums[right];
	                 
	            }
	            else if(sum>=target){
	                size=Math.min(size,right-left+1);
	                sum-=nums[left];
	                left++;
	            }
	        }
	        return (size==Integer.MAX_VALUE)?0:size;
	    }
}
