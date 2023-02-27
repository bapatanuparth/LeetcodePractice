package leetCodeArrays2;

import java.util.HashSet;
import java.util.Set;

//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//
//Find the kth positive integer that is missing from this array.

//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
public class KthMissingPositiveInteger {

	//without using extra space
	 public int findKthPositiveEff(int[] nums, int k) {
	        int i=1;
	        
	        int j=0;
	        while(k>0){
	            if(j>=nums.length){
	                k--;i++;continue;
	            }
	            if(nums[j]!=i){
	                k--;
	            }    
	            if(i<nums[j])
	                i++;
	            else
	            {
	                j++;i++;
	            }
	        }
	        return i-1;
	    }
	
	
	//approach one
	   public int findKthPositive(int[] arr, int k) {
	        int i=1;
	        Set<Integer> set= new HashSet<>();
	        
	        for(int val:arr){
	            set.add(val);
	        }
	        
	        while(k>0){
	            if(!set.contains(i)){
	                k--;
	            }
	            i++;
	        }
	        return i-1;
	    }
}
