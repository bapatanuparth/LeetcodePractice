package leetCodeArrays;
import java.util.*;

//Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

//Input: nums = [1,2,3], k = 3
//Output: 2

//constraints
//1 <= nums.length <= 2 * 104
//-1000 <= nums[i] <= 1000
//-107 <= k <= 107
public class SubarraySumEqualK {
	
	//as problem has negative values in it, sliding window will fail. cannot be applied
	
	//Efficient solution using HashMap
	//store the prefix sum as key-value pair with its frequency of appearance
	//every time we encounter new sum, store it as new pair
	//at every point check if sum-k has already appeared and if it has, increase the count by the frequency of that sum
	 public int subarraySumEff(int[] nums, int k) {
	        int count = 0, sum = 0;
	        HashMap < Integer, Integer > map = new HashMap < > ();
	        //put 0 sum as default
	        map.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	        	//calculate prefix sum
	            sum += nums[i];
	            //check if map has already seen sum-k. if it has, it means the middle subarray's sum == k
	            
	            if (map.containsKey(sum - k))
	                count += map.get(sum - k);
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	        return count;
	    }
	
	
	//solution using prefix sum
	//O(n2) and O(n)
	  public int subarraySum(int[] nums, int k) {
	        int presum[]=new int[nums.length];
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            presum[i]=sum;
	        }
	        int i=0,j=0,count=0;
	        for(j=0;j<presum.length;j++){
	            if(presum[j]==k)count++;
	            for(i=0;i<j;i++){
	                if(presum[j]-presum[i]==k)count++;
	            }
	        }
	        return count;
	        
	    }
	  
	  
}
