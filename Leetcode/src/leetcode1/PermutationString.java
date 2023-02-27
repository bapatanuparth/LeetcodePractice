package leetcode1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//Given two strings s1 and s2, 
//return true if s2 contains a permutation of s1, or false otherwise.

public class PermutationString {
	
	//solution has become complex -->
    public static boolean checkInclusion(String s1, String s2) {
     Map<Character,Integer> map=new HashMap<>();
     Map<Character,Integer> temp=new HashMap<>();
     int value=0;
     for(int i=0;i<s1.length();i++) {
    	 if(map.containsKey(s1.charAt(i)))
    		 map.replace(s1.charAt(i), map.get(s1.charAt(i))+1);
    	 else map.put(s1.charAt(i), value+1);
     }
     int count=0;
     for(int i=0;i<s2.length();i++) {
    	 if(!map.containsKey(s2.charAt(i))) {
    		 temp.clear();
    		 count=0;
    		 continue;
    	 }
    	 else if(map.containsKey(s2.charAt(i))) {
    		 count++;
    		 System.out.println(i+"  "+count);
    		 if(count>s1.length()) {
    			 temp.replace(s2.charAt(i-count+1), temp.get(s2.charAt(i-count+1))-1);
      			 count--;
    		 }
    		 if(temp.containsKey(s2.charAt(i)))
        		 temp.replace(s2.charAt(i), temp.get(s2.charAt(i))+1);
        	 else temp.put(s2.charAt(i), value+1);
    		 if(map.equals(temp))return true;
    	 }
     }
    return false;
    }
    //more efficient sliding window
    public static boolean checkInclusion2(String s1, String s2) {
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> temp=new HashMap<>();
        int value=0;
        for(int i=0;i<s1.length();i++) {
       	 if(map.containsKey(s1.charAt(i)))
       		 map.replace(s1.charAt(i), map.get(s1.charAt(i))+1);
       	 else map.put(s1.charAt(i), value+1);
        }

        for(int i=0;i<s1.length();i++) {
        	 if(temp.containsKey(s2.charAt(i)))
           		 temp.replace(s2.charAt(i), temp.get(s2.charAt(i))+1);
           	 else temp.put(s2.charAt(i), value+1);
        }
        if(map.equals(temp))return true;
        int j=s1.length();
        int i=0;
        //sliding window
		while(j<s2.length()) {
			temp.replace(s2.charAt(i), temp.get(s2.charAt(i))-1);
			if(temp.containsKey(s2.charAt(j)))
          		 temp.replace(s2.charAt(j), temp.get(s2.charAt(j))+1);
          	 else temp.put(s2.charAt(j), value+1);
			 if(map.equals(temp))return true;
			i++;j++;
		}
       return false;
       }
    
    public static void main(String[] args) {
		System.out.println(checkInclusion2("abc", "ccbcda"));
	}
}
