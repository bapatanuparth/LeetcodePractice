package leetCodeArrays;
import java.util.*;

//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array 
//such that nums[i] == nums[j] and abs(i - j) <= k.

//k can be thought of as a window
public class ContainsDuplicate {

	//abs(i-j) can be thought of as a window size
	//check if there are any repetitions in the window size k and keep moving the window
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int left=0,right=0;
        while(right<nums.length && right<=k){
            if(set.contains(nums[right]))return true;
            else
                set.add(nums[right]);
            right++;
        }
        while(right<nums.length){
            set.remove(nums[left]);
            if(set.contains(nums[right]))return true;
            else set.add(nums[right]);
            left++;  right++;
        }
        return false;
    }
}
