package leetcode1;

import java.util.HashSet;
import java.util.Set;


//Given two strings s and goal,return true if you can swap two letters in s
//so the result is equal to goal,otherwise, return false.

//Input: s = "ab", goal = "ba"
//Output: true
public class BuddyStrings {

	   public boolean buddyStrings(String s, String goal) {
	        if (s.length() != goal.length() || s.length() == 1) return false; //can't be valid if these conditions are met.

	        Set<Character> uni = new HashSet<>(); //use set to track num of unique characters
	        int n = s.length(), j = -1, w = -1; //j, w are the indexes where they differ
	        for (int i = 0; i < n; uni.add(s.charAt(i++))){ //add current character to the set
	            if (s.charAt(i) == goal.charAt(i)) continue;
	            if (w != -1 && j != -1) return false; //can't have more than 2 differences
	            if (w == -1 && j != -1) w = i; //update w if j has been updated.
	            if (j == -1) j = i; //update j
	        }

	        if (w == -1 && j == -1) return uni.size() != n; //indentical strings, check if there is a duplicate character
	        if (w == -1 || j == -1) return false; //must have 2 differences, not 1
	        return s.charAt(w) == goal.charAt(j) && s.charAt(j) == goal.charAt(w); //check if the characters are actually identical
	    }
}
