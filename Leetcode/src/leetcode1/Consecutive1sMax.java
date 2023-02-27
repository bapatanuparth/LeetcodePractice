package leetcode1;

//max consecutive ones in an array
public class Consecutive1sMax {
	  public int findMaxConsecutiveOnes(int[] nums) {
	        int res=0;
	        int i=0;
	        while(i<nums.length){
	            int count=0;
	            int j=i;
	            while(i<nums.length && nums[i]==nums[j]){
	                if(nums[j]==1)count++;
	                i++;
	            }
	            res=Math.max(res,count);
	        }
	        return res;
	    }

}
