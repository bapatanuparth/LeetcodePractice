package leetcode1;

//Given a non-empty array of integers nums, every element appears twice except for one.
//Find that single one.
public class SingleNumber {
	
	//Using XOR to find solution in O(1)
	// Can also use Hashmap or Hashset but the solution would not be in constabt extra space
    public static int singleNumber(int[] nums) {
    	int unique=0;
    	//XOR automatically will eliminate duplicates.
    	//^ performs bitwose XOR operation and we know 1^1==0, 0^0==0
    	//hence, for numbers, it will keep only the one that is single
    	for(int n:nums) {
    		unique ^=n;
    	}
    	return unique;
    }

}
