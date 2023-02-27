package leetCodeArrays2;

import java.util.Arrays;


//You are given an integer array nums. In one move, you can choose one element of nums and change it by any value.
//
//Return the minimum difference between the largest and smallest value of nums after performing at most three moves.


//sort the array first
//we can reduce 3 numbers between top 3 and bottom 3 and combinations become-->
//1. make top 3 == lowest and compare with arr[lowest +1]
//2. make bottom 1 and top 3 == arr[1] --> as we choose arr[0] as a value to be changed
//3. make bottom 2 and top 3 == arr[2]
//4. make bottom 3 == arr[3] and compare with arr[4]
public class MinDiffInnLargestAndSmallestVal {

	 public int minDifference(int[] nums) {
	        Arrays.sort(nums);
	        
	        if(nums.length<=3)return 0;
	        int n=nums.length;
	        
	        int res=Integer.MAX_VALUE;
	        for(int i=0;i<=3;i++){
	            res=Math.min(res,nums[n-3+(i-1)]-nums[i]); //n-3+(i-1) to points to the element with which nums[i] should be compared
	        }
	        
	        return res;
	        
	    }
}
