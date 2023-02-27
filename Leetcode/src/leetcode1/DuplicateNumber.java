package leetcode1;


//check this problem on leetcode -- very unique and insightful solutions
//Linked list cycle II solution
//Floyd's tortoise and hare cycle detection

//Given an array of integers nums containing
//n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.
public class DuplicateNumber {
		
		//Input: nums = [1,3,4,2,2] --> Output: 2
	
	
		//Negative Marking
		public static int negativeMarking(int nums[]) {
	        int duplicate = -1;
	        for (int i = 0; i < nums.length; i++) {
	            int cur = Math.abs(nums[i]);
	            if (nums[cur] < 0) {
	                duplicate = cur;
	                break;
	            }
	            nums[cur] *= -1;
	        }
	        
	        // Restore numbers
	        for (int i = 0; i < nums.length; i++)
	            nums[i] = Math.abs(nums[i]);

	        return duplicate;
		}
		
		
	//wrong solution -- XNOR cannot be implemented directly	
	    public static int findDuplicate(int[] nums) {
	        int curr=0;
	        for(int i=0;i<nums.length;i++) {
	        	curr=~(curr^nums[i]);
	        }
	        return curr;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(negativeMarking(new int [] {1,3,5,7,4}));
		}
	   
}

