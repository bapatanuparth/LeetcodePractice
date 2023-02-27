package leetcode1;


//move zeros in an array to the end
public class MoveZeros {
	 public void moveZeroes(int[] nums) {
	        int start=0;
	        int count=0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]!=0)
	            {
	                nums[start]=nums[i];
	                start++;
	            }
	            else if(nums[i]==0)
	                count++;
	        }
	        int last=nums.length-1;
	        for(int i=0;i<count;i++){
	            nums[last]=0;
	            last--;   
	        }

	    }
}