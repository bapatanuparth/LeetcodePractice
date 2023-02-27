package leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


//solution is incorrect ----------

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
//such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
public class ThreeSum {

	//0->1    1->0
	//[-1,0,1,2,-1,-4]
	//convert threesum problem to twosum
	//target sum --> send to twosum
	public static List<Integer> twoSum(int nums[], int sum, int i){
		Map<Integer,Integer> map=new HashMap<>();
		Map<Integer,Integer> revmap=new HashMap<>();
		List<Integer> temp=new ArrayList<>();
		List<List<Integer>> result=new ArrayList<>();
		//add element pairs in map with element --> sum-element
		for(int j=0;j<nums.length;j++) {
			if(j==i)continue;	
				map.put(nums[j], sum-nums[j]);
				revmap.put(sum-nums[j], nums[j]);
				
		}
		//check if the sum-element is present in given array.
		// if present, add all 3 elements in output
		//Need to figure out how to keep the solution unique
		for(int j=0;j<nums.length;j++) {
			if(j==i)continue;
			if(map.containsValue(nums[j])){
				if(sum-nums[j]==nums[j] )continue;
				temp.add(nums[i]);
				temp.add(revmap.get(sum-nums[j]));
				temp.add(map.get(nums[j]));
				System.out.println(temp);
				result.add(temp);
				temp.clear();
			}
		}
		return temp;	
		}
	
	//[-1,0,1,2,-1,-4]
    public static List<List<Integer>> threeSum(int[] nums) {
    	Map<Integer,Integer> map=new HashMap<>();
    	List<List<Integer>> result=new ArrayList<>();
    	for(int i=0;i<nums.length;i++) {
    		int temp=nums[i];
    		int target=0-temp;
    		twoSum(nums,target,i);
    		}
    return result;	
    }
    
    public static void main(String[] args) {
    	threeSum(new int[] {-1,0,1,2,-1,-4});
	}
    }

