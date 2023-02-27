package leetCodeArrays;

//Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of
//all the elements in the subarray is strictly less than k.

//Input: nums = [10,5,2,6], k = 100
//Output: 8
//Explanation: The 8 subarrays that have product less than 100 are:
//[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
public class SubarrayProductLessThanK {

	//challenging sliding window
	 public int numSubarrayProductLessThanK(int[] nums, int k) {
	        if(k<=1)return 0;
	        int prod=1, ans=0;
	        int left=0,right=0;
	        for(right=0;right<nums.length;right++){
	            prod=prod*nums[right];
	            while(prod>=k)prod/=nums[left++];
//	            If we start at the 0th index, [10], the number of intervals is obviously 1.
//	            If we move to the 1st index, the window is now [10,5]. The new intervals created are [5] and [10,5], so we add 2.
//	            for 2nd index, 2 will make prod=100, so we move left. now window=[5,2] which makes 2 intervals [5,2] and [2]
	            ans+=right-left+1;
	        }
	        
	        return ans;
	    }
}
