package leetcodeStrings;
import java.util.*;

//You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
//
//Return the minimum number of steps to make t an anagram of s.
//
//An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

//Input: s = "bab", t = "aba"
//Output: 1
//Input: s = "leetcode", t = "practice"
//Output: 5

public class MinNumStepsToMakeAnagram {

	 public int minSteps(String s, String t) {
		    Map<Character,Integer> maps= new HashMap<>();
		        Map<Character,Integer> mapt= new HashMap<>();
		        
		        for(char c:s.toCharArray()){
		            maps.put(c, maps.getOrDefault(c,0)+1);
		        }
		        for(char c:t.toCharArray()){
		            mapt.put(c, mapt.getOrDefault(c,0)+1);
		        }
		        
		        Set<Character> set = new HashSet<>();
		        for(int i=0;i<s.length();i++){
		            set.add(s.charAt(i));
		        }
		        int op=0;
		     
		        for(char ch:set){
		            if(mapt.containsKey(ch)){
		                if(mapt.get(ch)<maps.get(ch)){
		                    op+=maps.get(ch)-mapt.get(ch);
		                }
		                
		            }
		            else
		                op+=maps.get(ch);
		        }
		        return op;
		    }
}
