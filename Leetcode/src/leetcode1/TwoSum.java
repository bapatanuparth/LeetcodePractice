package leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, 
//return indices of the two numbers such that they add up to target
public class TwoSum {
	public static void main(String[] args) {
		Arrays.toString(twoSum(new int[] {3,2,4},6));
	}
	
	//index --> target-arr[index]
	
    static public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer>map=new HashMap<Integer, Integer>();
    	Map<Integer, Integer>revmap=new HashMap<Integer, Integer>();
    	int arr[]=new int[2];
        for(int i=0;i<nums.length;i++) {
        	if(map.containsValue(nums[i])) {
        		arr[0]=revmap.get(nums[i]);
        		arr[1]=i;
        	}
        	else if(!map.containsValue(nums[i])) {
        		map.put(i, target-nums[i]);
        		revmap.put(target-nums[i],i);
        		
        	}
        }
        return arr;
    }
}
