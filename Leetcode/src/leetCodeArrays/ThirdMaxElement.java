package leetCodeArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//Given an integer array nums, return the third distinct maximum number in this array.
//If the third maximum does not exist, return the maximum number.

//Input: nums = [2,2,3,1]
//Output: 1
public class ThirdMaxElement {

	  public int thirdMax(int[] nums) {
	        Arrays.sort(nums);
	       
	        int i=nums.length-1;
	        int count=0;
	        if(nums.length<3)return nums[i];
	        Set<Integer> set = new HashSet<>();
	        while(i>=0){
	            if(!set.contains(nums[i])){
	                set.add(nums[i]);
	                count++;
	            }
	            if(count==3)return nums[i];
	            i--;
	        }
	        return nums[nums.length-1];
	    }
}
