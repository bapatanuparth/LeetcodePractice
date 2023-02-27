package leetcodeStrings;

import java.util.*;

//Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
//
//If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

//Input: words = ["w","wo","wor","worl","world"]
//Output: "world"

//Input: words = ["a","banana","app","appl","ap","apply","apple"]
//Output: "apple"
public class LongestWord {

	 public String longestWord(String[] words) {
		 //store all the words in hashet to check if ppresent
	        Set<String> set= new HashSet<>();
	        
	        for(String s:words)set.add(s);
	 //sort the array in descending order of length, also if 2 words are equal length, the one lexicographically small should be first
	        Arrays.sort(words, (a,b)-> a.length()==b.length()?a.compareTo(b):b.length()-a.length());
	        
	        
	        for(String s:words){
	        //for each word in words which is sorted in descending order of length    
	            boolean good=true;
	            //check if every substring of the word is present in array
	            for(int i=1;i<s.length();i++){
	                if(!set.contains(s.substring(0,i))){
	                    good=false;
	                    break;
	                }
	            }
	            //if word is good, return it
	            if(good) return s;
	        }
	        return "";
	    }
}
