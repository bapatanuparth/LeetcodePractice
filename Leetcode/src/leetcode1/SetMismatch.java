package leetcode1;

import java.util.HashSet;
import java.util.Set;

//Find the number that occurs twice and the number that is missing and return them in the form of an array.
//You have a set of integers s, which originally contains all the numbers from 1 to n
public class SetMismatch {
	
	//problem can also be solved using bitwise XOR, refer to the leetcode solution
	
	//needs to rework
    public int[] findErrorNums2(int[] nums) {
        int [] result=new int[2];
        int [] temp=new int[nums.length];
        int curr=0;
        for(int i=0;i<nums.length;i++){
        	curr=nums[i];
        	if(temp[curr-1]!=0)result[0]=curr;
        	temp[curr-1]=nums[i];
        }
        for(int i=1;i<=nums.length;i++) {
        	if(temp[i]==0)
        		result[1]=temp[i]+1;
        }
        return result;
    }
    
    //working solution
    public int[] findErrorNums(int[] nums) {
    Set<Integer> set=new HashSet<>();
        int [] result=new int[2];
        for(int i=0;i<nums.length;i++){
        	if(set.contains(nums[i]))
        		result[0]=nums[i];
        	else set.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++) {
        	if(!set.contains(i))
        		result[1]=i;
        }
        return result;
    }
    
    public static void main(String[] args) {
		
	}
}
