package leetCodeArrays2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//You are given an integer array nums and an integer k. Append k unique positive integers that do not appear in nums to nums such that the resulting total sum is minimum.
//
//Return the sum of the k integers appended to nums.
public class AppendKIntegersMinimalSum {
	
	
	//algo-->
	//calculate the whole sum of elements till k using ans ==k*(k+1)/2
	//now check how many elements from 1 to k are in the array and subtract that value from ans -- here we compensate for elements counted that are already in array
	//now add the new elements == count of elements between 1 to k provided that those are not already present in the array
	 public long minimalKSumEff(int[] nums, int k) {
	        Arrays.sort(nums);
	        Set<Integer> set= new HashSet<>(); //add in set for O(1) lookup
	        for(int i:nums){
	            set.add(i);
	        }
	   
	        long sum=(long) k * (k+1)/2; //default sum
	        
	        int next_val=k+1;
	        int count=0;
	        
	        for(int i=0;i<nums.length;i++){ //check the elements which are between 1 to k and in nums array
	        
	            if(i!=0 && nums[i]==nums[i-1])
	                continue;
	            if(nums[i]<=k){
	                count++;
	                sum-=nums[i];
	            }
	            else if(nums[i]>k)break;
	        }
	        
	        while(count>0){ //if some elements are removed, add those elements only if they arent already present
	            if(!set.contains(next_val)){
	                sum+=next_val;
	                count--;
	            }
	            next_val++;
	        }
	        
	        return sum;
	    }
	

	//gives TLE
	 public long minimalKSum(int[] nums, int k) {
	      Set<Integer> set= new HashSet<>();
	        for(int i:nums){
	            set.add(i);
	        }
	        int temp=k;
	        int i=1;
	        long sum=0;
	        while(temp>0){
	            if(!set.contains(i)){
	                sum+=i;
	                temp--;
	            }
	            i++;
	        }
	        
	        return sum;
	    }
}
