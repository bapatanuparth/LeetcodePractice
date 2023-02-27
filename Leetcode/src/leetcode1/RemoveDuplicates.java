package leetcode1;

import java.util.Arrays;


//remove all duplicate occurrences of elements in a sorted array
public class RemoveDuplicates {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int [] {0,0,1,1,1,1,2,2,3,4,4}));
	}

    static public int removeDuplicates(int[] nums) {
        int start=0;
        int k=1;
        if(nums.length==0)return 0;
        for(int i=1;i<nums.length;i++) {
        	if(nums[i]!=nums[start])
        	{
        		k++;
        		nums[start+1]=nums[i];
        		start++;

        	}
        }
        return k;
        
    }
}
