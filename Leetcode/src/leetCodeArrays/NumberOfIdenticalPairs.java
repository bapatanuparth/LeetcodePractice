package leetCodeArrays;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums, return the number of good pairs.
//
//A pair (i, j) is called good if nums[i] == nums[j] and i < j.

//Input: nums = [1,2,3,1,1,3]
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

public class NumberOfIdenticalPairs {

	 public int numIdenticalPairs(int[] nums) {
	        Map<Integer,Integer> map=new HashMap();
	        int count=0;
	        for(int i:nums){
	          map.compute(i,(k,v)->(v==null)?1:v+1);
	        }
	        
	        for(int i:map.keySet()){
	            int temp=map.get(i);
	            count+=temp*(temp-1)/2;
	        }
	        return count;
	    }
}
