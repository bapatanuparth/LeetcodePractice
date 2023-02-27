package leetCodeArrays2;

import java.util.HashMap;
import java.util.Map;

//We are given hours, a list of the number of hours worked per day for a given employee.
//
//A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
//
//A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
//
//Return the length of the longest well-performing interval.

//Input: hours = [9,9,6,0,6,6,9]
//Output: 3
//[4,5,5,4,9,9,9,9]
//Output : 7		
public class LongestWellPerformingInterval {

	 public int longestWPI(int[] hours) {
	        int [] arr = new int[hours.length];
	        
	        for(int i=0;i<hours.length;i++){ //assign +1/-1 based on if val >8
	            if(hours[i]>8)
	                arr[i]=1;
	            else
	                arr[i]=-1;
	        }
	        
	        int [] presum = new int[hours.length];
	        presum[0]=arr[0]; 
	        for(int i=1;i<arr.length;i++){ //calculate prefix sum
	            presum[i]=presum[i-1]+arr[i];
	        } 
	        
	        //now find the smallest i for each j of presum such that, presum[j]-1=presum[i]
	        //use hashmap to store all presums with the indexes seen before
	        //update res based on the difference between i and j in each iteration
	        //if res>0, it means values with >8 are more than values <8, so directly update res if val at presum[i]>0
	        Map<Integer, Integer> map= new HashMap<>();
	        int res=0;
	        for(int i=0;i<presum.length;i++){
	            if(presum[i]>0)
	                res=i+1;
	            else{
	                if(!map.containsKey(presum[i])){
	                    map.put(presum[i],i);
	                }
	                if(map.containsKey(presum[i]-1)){
	                    res=Math.max(res,i-map.get(presum[i]-1));
	                }
	            }
	        }
	        return res;
	    }
}
