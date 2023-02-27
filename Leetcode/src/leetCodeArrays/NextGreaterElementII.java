package leetCodeArrays;

import java.util.Stack;

//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
//The next greater number of a number x is the first greater number to its traversing-order next in the array, 
//which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.


//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; 
//The number 2 can't find next greater number. 
//The second 1's next greater number needs to search circularly, which is also 2.
public class NextGreaterElementII {

	//optimized solution using stack
	  public int[] nextGreaterElementsEff(int[] nums) {
	       int n = nums.length;
	        Stack<Integer> stack = new Stack();
	        for(int i = n - 1; i >= 0; i--){
	          stack.push(i);   
	        }
	        
	        int[] res = new int[n];
	        for(int i = n - 1; i >= 0; i--){
	            res[i] = -1;
	            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
	              stack.pop();  
	            }
	            
	            if(!stack.isEmpty()) res[i] = nums[stack.peek()];
	            stack.push(i);
	        }
	        return res;
	    }
	
	
	//brute force optimized
	 public int[] nextGreaterElements(int[] nums) {
	       
	        int[] res= new int [nums.length];
	        for(int i=0;i<nums.length;i++){
	            res[i]=-1;
	            for(int j=1;j<nums.length;j++){
	                if(nums[(i+j)%nums.length]>nums[i]){
	                    res[i]=nums[(i+j)%nums.length];
	                    break;
	                }
	            }
	        }
	        return res;
	    }
}
