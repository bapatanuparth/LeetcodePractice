package leetCodeArrays2;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
//
//Return the largest lucky integer in the array. If there is no lucky integer return -1.

//Input: arr = [2,2,3,4]
//Output: 2
public class FindLuckyInteger {

	   public int findLucky(int[] arr) {
		     Map<Integer,Integer> map= new HashMap<>();
		        for(int i:arr){ //get frequency
		            map.put(i,map.getOrDefault(i,0)+1);
		        }
		        
		        int res=-1;
		        for(int i:map.keySet()){
		            if(i == map.get(i)) //get maximum among all lucky
		                res=Math.max(res,i);
		        }
		        
		        return res;
		    }
}
