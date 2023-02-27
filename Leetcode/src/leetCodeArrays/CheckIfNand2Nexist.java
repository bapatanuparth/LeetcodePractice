package leetCodeArrays;

import java.util.*;

//Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

//Input: arr = [10,2,5,3]
//Output: true

//Input: arr = [7,1,14,11]
//Output: true
public class CheckIfNand2Nexist {

	public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]*2))
                return true;
            else if(arr[i]%2==0 && set.contains(arr[i]/2))
                return true;
            else
                set.add(arr[i]);
        }
        return false;
    }
}
