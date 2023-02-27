package leetcodeStrings;
import java.util.*;
//microsoft


//You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
//
//Return the maximum possible length of s.
//
//A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

//Input: arr = ["un","iq","ue"]
//Output: 4

public class MaxLengthConcatStringUniqueCharacters {

	//check if given string is unique
	  public boolean checkUnique(String s){
	        int [] fq= new int[26];
	        for(char c: s.toCharArray()){
	            if(++fq[c-'a']>1)
	                return false;
	        }
	        return true;
	        
	    }
	    
	    
	  public int maxLength(List<String> arr) {
	        
	        List<String> list= new ArrayList<>();
	        int ans=0;
	        for(String str: arr){
	            
	            List<String> tmp= new ArrayList<>(); //tmp list to try all combinations 
	            if(!checkUnique(str))
	                continue;
	            
	            tmp.add(str);
	            ans=Math.max(ans, str.length());
	            
	            for(String s: list){
	                String temp= s+str; //if the string combination is unique, check for the length
	                if(checkUnique(temp)){
	                    tmp.add(temp); //add to the tmp as this now becomes a valid base string to check further with new strings from arr
	                    ans= Math.max(ans, temp.length());
	                }
	            }
	            list.addAll(tmp); //add all the valid combinations to list, which is main list having all possible combinations
	            //checked till now, we keep building this list with all possible combinations
	        }
	        return ans;
	    }
}
