package leetCodeArrays;

//You are given an integer array nums where the largest integer is unique.
//
//Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, 
//return the index of the largest element, or return -1 otherwise.

//Input: nums = [3,6,1,0]
//Output: 1

//Input: nums = [1,2,3,4]
//Output: -1
public class LargestNumAtLeastTwiceOfOthers {

	 public int dominantIndex(int[] nums) {
	        int max=Integer.MIN_VALUE, maxIndex=0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]>max){
	                max=nums[i];
	                maxIndex=i;
	            }
	        }
	        
	        for(int i=0;i<nums.length;i++){
	            if(i==maxIndex)continue;
	            if(nums[i]*2>max)return -1;
	        }
	        return maxIndex;
	    }
}
