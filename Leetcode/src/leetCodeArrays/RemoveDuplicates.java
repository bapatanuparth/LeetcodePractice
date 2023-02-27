package leetCodeArrays;

import java.util.Arrays;

//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. 
//The relative order of the elements should be kept the same.

//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//		
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
public class RemoveDuplicates {
	
	public int removeDuplicatesEff(int[] nums) {
		int count = 1;
		int k = nums.length;
		//J loop to Enter values According to condition
		int j=1;
		//we start to look from 1 where duplicates might start occuring from
		for(int i=1;i<nums.length;i++){
			if(nums[i]==nums[i-1]){
				count++;
		//If Duplicates less than 3 than add values to j position
				if(count<=2){
					nums[j]=nums[i];
					j++;
				}
			}
			else{
		//Non duplicate Element so reset counter and add value at j position
				count = 1;
				nums[j]=nums[i];
				j++;
			}
		}
			return j;
		}
		

	 public int removeDuplicates(int[] nums) {
	        if(nums.length==1)return 1;
	        int diff=0;
	        int count=1;
	        for(int i=1;i<nums.length-diff;i++){
	            if(nums[i]==nums[i-1] && count==2){
	                int j=i,temp=i;
	                int d=diff;
	                while(j<nums.length-d && nums[j]==nums[i]){
	                    diff++;j++;}
	                while(j<nums.length){
	                    nums[temp]=nums[j];
	                    j++;temp++;
	                }
	                count=1;
	                System.out.println(Arrays.toString(nums));
	                System.out.println(diff);
	            }
	            if(nums[i]==nums[i-1]){
	                count++;
	            }else count=1;
	        }
	        return nums.length-diff;
	    }
}
