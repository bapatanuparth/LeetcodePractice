package leetcode1;

import java.util.*;
//Two strings are considered close if you can attain one from the other using the following operations:
//
//Operation 1: Swap any two existing characters.
//For example, abcde -> aecdb
//Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
//For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

//Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
public class TwoCloseStringsCheck {

	  public boolean closeStrings(String word1, String word2) {
	        if(word1.length()!=word2.length())return false;
	        Map<Character, Integer> map=new HashMap<>();
	        Map<Character, Integer> map2=new HashMap<>();
	        for(int i=0;i<word1.length();i++){
	            map.compute(word1.charAt(i),(ch, count)->(count==null)?1:count+1);
	        }
	        for(int i=0;i<word2.length();i++){
	            map2.compute(word2.charAt(i),(ch, count)->(count==null)?1:count+1);
	        }
	        System.out.println(map);
	        System.out.println(map2);
	        boolean x=isSame(map.values(), map2.values( ));

	        //can take map.values() i 2 arrayLists
	        //sort 2 arrayLists and check if they are equal
	        //2 arraylists after sorting will be equal only if they follow the required constraints of characters 
	        //having same frequencies
	        return map.keySet().equals(map2.keySet()) && x;
	    }
	     boolean isSame(Collection a, Collection b) {
	        Map<Object, Integer> map = new HashMap<>();
	        for(Object obj : a) {
	            map.put(obj, map.getOrDefault(obj, 0) + 1);
	        }
	        
	        for(Object obj : b) {
	            if(!map.containsKey(obj) || map.get(obj) <= 0) return false;
	            map.put(obj, map.get(obj)-1);
	        }
	        
	        return true;
	    }
}
