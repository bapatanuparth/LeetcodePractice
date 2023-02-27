package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctElement {

	//using map.compute method to write and update map
	 public String kthDistinct(String[] arr, int k) {
	        Map<String, Integer> map=new HashMap<>();
	        
	        for(String s:arr){
	            map.compute(s, (str, count) -> count == null ? 1 : count + 1);
	        }
	        int val=0;
	        for(String str:arr){
	            System.out.println(str + map.get(str));
	            if(map.get(str)==1)
	                val++;
	            if(val==k) return str;
	        }
	        return "";
	    }
}
