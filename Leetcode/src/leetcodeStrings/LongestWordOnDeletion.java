package leetcodeStrings;

import java.util.Collections;
import java.util.List;

//Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

//Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//Output: "apple"
public class LongestWordOnDeletion {

	//check if the word in dictionary is a subsequece
	  public boolean isSubsequence(String x, String y){
	        int j=0;
	        //for each char from reference string s, if char is present at "j" , increment "j"
	        //if j== length of the word, it means all the characters were found in the reference string as subsequence
	        for(int i=0;i<y.length()&& j<x.length();i++){
	            if(x.charAt(j)==y.charAt(i))
	                j++;
	        }
	        return j==x.length();
	    }
	    
	    public String findLongestWord(String s, List<String> d) {
	        Collections.sort(d, (a,b)-> a.length()==b.length()?a.compareTo(b):b.length()-a.length());
	        
	        for(String str:d){
	            if(isSubsequence(str,s))
	                return str;
	        }
	        
	        return "";
	    }
}
