package leetcode1;


//Given an array nums containing n distinct numbers in the range [0, n], 
//return the only number in the range that is missing from the array.
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n=nums.length,sum=0;
        for(int i=1;i<=n;i++) {
        	sum=sum+nums[i];
        }
        for(int i=0;i<nums.length;i++) {
        	sum=sum-nums[i];
        }
        return sum;
    }
}
