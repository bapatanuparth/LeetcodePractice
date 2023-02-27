package leetcode1;

//remove all occurrences of a specified element of an array

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int start=0,k=0;
        if(nums.length==0)return 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val)
            {
              nums[start]=nums[i];
              start++;
              k++;
            } 
            
        }
        return k;
    }
}
