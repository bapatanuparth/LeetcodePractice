package leetCodeArrays2;
import java.util.*;

//You are given an integer array nums consisting of 2 * n integers.
//
//You need to divide nums into n pairs such that:
//
//Each element belongs to exactly one pair.
//The elements present in a pair are equal.
//Return true if nums can be divided into n pairs, otherwise return false

//Input: nums = [3,2,3,2,2,2]
//Output: true

public class DivideArrayEqualPart {

	 public boolean divideArray(int[] nums) {
	        Map<Integer,Integer> map= new HashMap<>();
	        
	        for(int i:nums){
	            map.put(i, map.getOrDefault(i,0)+1);
	        }
	        
	        for(int i:map.keySet()){
	            if(map.get(i)%2!=0)return false;
	        }
	        
	        return true;
	    }
}
