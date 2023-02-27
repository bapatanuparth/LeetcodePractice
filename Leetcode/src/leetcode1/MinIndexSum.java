package leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//find common string from 2 arrays
//if 2 commons are there, return the first one
public class MinIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
    	//add all values in a map
    	Map<String,Integer> map=new HashMap<>();
    	for(int i=0;i<list1.length;i++) {
    		map.put(list1[i],i);
    	}
    	List<String> res=new ArrayList<>();
    	int minsum=Integer.MAX_VALUE,sum;
    	//iterate through second list and find matches
    	for(int j=0;j<list2.length;j++) {
    		if(map.containsKey(list2[j])) {
    			//if matched, take sum of their indexes and see if its less than previous minsum
    			//if less, add in res
    			sum=j+map.get(list2[j]);
    			if(sum< minsum) {
    				res.clear();
    				res.add(list2[j]);
    				minsum=sum;
    			}
    			else if(sum==minsum)res.add(list2[j]);
    		}
    	}
    	return res.toArray(new String[res.size()]);
        
    }
    
    public static void main(String[] args) {
	String[] s1 = {"Shogun","Tapioca Express","Burger King","KFC"};
	String[] s2 = {"Piatti","Burger King","Shogun"};
	}
}
