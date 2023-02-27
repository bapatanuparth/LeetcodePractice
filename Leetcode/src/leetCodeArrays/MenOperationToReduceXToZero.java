package leetCodeArrays;

//You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
//
//Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

//Input: nums = [1,1,4,2,3], x = 5
//Output: 2
public class MenOperationToReduceXToZero {

	//sliding window
	//think of solution as reverse, instead of finding minimum elements == x, find maximum sub array with sum== prefixsum-x
	//instead of finding the minimum prefix + suffix, find the maximum subarray.
	 public int minOperations(int[] nums, int x) {
		    //calculate prefix sum
	        long presum=0;
	        for(int i:nums)
	            presum+=i;
	        //our aim is to find maximum subarray with sum = total sum - x
	        int val=(int)(presum-x);
	        
	        int left=0,right=0,sum=0;
	        int count=-1;
	        //sliding window
	        while(right<nums.length){
	            sum+=nums[right];
	            while(left<=right && sum>val){
	                sum-=nums[left++];
	            }
	            if (sum==val)
	            {
	                count=Math.max(count,right-left+1);
	            }
	            right++;
	            
	        }
	        return (count==-1)?-1:nums.length-count;
	    }
}
