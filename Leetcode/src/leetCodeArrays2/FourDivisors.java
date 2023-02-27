package leetCodeArrays2;

import java.util.HashSet;
import java.util.Set;

//Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

//Input: nums = [21,4,7]
//Output: 32
public class FourDivisors {

	
	 public int sumFourDivisors(int[] nums) {
	        int sum=0;
	        Set<Integer> set = new HashSet<>();
	        for(int i=0;i<nums.length;i++){
	            
	            int temp= nums[i];
	            //calculate divisors of each element
	            for(int j=2;j*j<=temp;j++){
	                    if(temp%j==0){ //check if theres only 4 divisors
	                        set.add(j);
	                        set.add(temp/j);
	                    }
	            }
	            
	            if(set.size()==2){
	                sum=sum+1+temp;
	                for(int k:set){
	                    sum+=k;
	                }
	            }
	            set.clear();
	    }
	        return sum;
	    }
}
