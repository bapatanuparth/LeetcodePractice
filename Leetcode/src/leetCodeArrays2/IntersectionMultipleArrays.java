package leetCodeArrays2;
import java.util.*;

//Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.

//Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
//Output: [3,4]
public class IntersectionMultipleArrays {
//	Keep a count of the number of times each integer occurs in nums.
//	Since all integers of nums[i] are distinct, if an integer is present in each array, its count will be equal to the total number of arrays.
	
	
	//faster code
	//use array of size 1001 instead of map to store frequencies
	 public List<Integer> intersectionEff(int[][] nums) {
	        int[] count = new int[1001];
	        List<Integer> intersection = new ArrayList<>();
	        for(int[] array : nums) {
	            for(int number : array) {
	                count[number]++;
	            }
	        }
	        for(int i = 1; i < count.length; i++) {
	            if(count[i] == nums.length) {
	                intersection.add(i);
	            }
	        }
	        return intersection;
	    }

	 public List<Integer> intersection(int[][] nums) {
	       Map<Integer, Integer> map = new TreeMap<>();
	        for(int arr[] :nums){
	            
	            for(int i:arr){
	                map.put(i, map.getOrDefault(i,0)+1);
	            }
	        }
	        
	        List<Integer> res= new ArrayList<>();
	        for(int j:map.keySet()){
	            if(map.get(j) == nums.length)
	                res.add(j);
	        }
	        
	        
	        return res;
	 }
}
