package leetcodeStrings;
import java.util.*;

//You are given two strings s and t. In one step, you can append any character to either s or t.
//
//Return the minimum number of steps to make s and t anagrams of each other.
//
//An anagram of a string is a string that contains the same characters with a different (or the same) ordering.

//Input: s = "leetcode", t = "coats"
//Output: 7
//- In 2 steps, we can append the letters in "as" onto s = "leetcode", forming s = "leetcodeas".
//- In 5 steps, we can append the letters in "leede" onto t = "coats", forming t = "coatsleede".
public class MinStepsToMakeAnagram {

	 public int minSteps(String s, String t) {
	        Map<Character, Integer> maps= new HashMap<>();
	        Map<Character, Integer> mapt= new HashMap<>();
	        
	        for(char c: s.toCharArray()){
	            maps.put(c,maps.getOrDefault(c,0)+1);
	        }
	        
	        for(char c: t.toCharArray()){
	            mapt.put(c,mapt.getOrDefault(c,0)+1);
	        }
	        
	        int count=0;
	        for(char ch:maps.keySet()){
	            if(!mapt.containsKey(ch)){
	                count+=maps.get(ch);
	                continue;
	            }
	            else{
	                count+=Math.abs(maps.get(ch)-mapt.get(ch));
	            }
	        }
	        for(char ch:mapt.keySet()){
	            if(!maps.containsKey(ch)){
	                count+=mapt.get(ch);
	            }
	        }
	        return count;
	    }
}
