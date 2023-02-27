package leetCodeArrays2;
import java.util.*;
import java.util.Map.Entry;

//You are given a 0-indexed integer array nums. You are also given an integer key, which is present in nums.
//
//For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums. In other words, count the number of indices i such that:
//
//0 <= i <= nums.length - 2,
//nums[i] == key and,
//nums[i + 1] == target.
//Return the target with the maximum count. The test cases will be generated such that the target with maximum count is unique.

//Input: nums = [1,100,200,1,100], key = 1
//Output: 100
//Input: nums = [2,2,2,2,3], key = 2
//Output: 2

public class MostFreqNumFolKey {

	 public int mostFrequent(int[] nums, int key) {
	        
	        Map<Integer,Integer> map= new HashMap<>();
	        for(int i=1;i<nums.length;i++){
	            if(nums[i-1]==key){
	                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
	            }
	        }
	        
	        int max=0, res=0;
	        for(Entry<Integer, Integer> e:map.entrySet()){
	            if(max<e.getValue()){
	                res= e.getKey();
	                max= e.getValue();
	            }    
	        
	        }
	        
	        return res;
	    }
}
