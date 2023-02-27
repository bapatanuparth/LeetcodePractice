package leetCodeArrays;

import java.util.*;

//You are given an integer array nums with the following properties:
//
//nums.length == 2 * n.
//nums contains n + 1 unique elements.
//Exactly one element of nums is repeated n times.
//Return the element that is repeated n times.
public class RepeatedNtimesIn2N {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set=new HashSet<>();
        
        for(int i:nums){
            if(set.contains(i))
                return i;
            else set.add(i);
        }
        return -1;
    }
}
