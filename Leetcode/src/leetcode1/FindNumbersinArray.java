package leetcode1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given an array nums of n integers where nums[i] is in the range [1, n],
//return an array of all the integers in the range [1, n] that do not appear in nums.
public class FindNumbersinArray {
	
	//O(n) time and O(n) space solution
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	set.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++) {
        	if(!set.contains(i))
        		result.add(i);
        }
        return result;
    }
    
    //O(n) --time , O(1) -- space solution
    
    public List<Integer> findDisappearedNumbersEff(int[] nums) {
        int idx = 0;
        while(idx < nums.length){
            int corrIdx = nums[idx] - 1;
            
            if(nums[idx] == nums[corrIdx]){
                idx++;
            }else{
                int temp = nums[idx];
                nums[idx] = nums[corrIdx];
                nums[corrIdx] = temp;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != (i+1)){
                res.add(i+1);
            }
        }
        return res;
    }
}
