package leetcode1;

//Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
//
//In one move, you can increment n - 1 elements of the array by 1.

 
public class MinMovesToMakeEqualArray {

	//this is a purely mathematical solution
	 public int minMoves(int[] nums) {
	        int sum=0,min=Integer.MAX_VALUE;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            min=Math.min(min,nums[i]);
	        }
	        int nums_sum=sum-nums.length*min;
	        return nums_sum;
	    }
}
