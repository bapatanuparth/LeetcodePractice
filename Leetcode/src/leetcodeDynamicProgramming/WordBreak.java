package leetcodeDynamicProgramming;

import java.util.List;

//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.

//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
public class WordBreak {

	 public boolean wordBreak(String s, List<String> wordDict) {
	     
	        boolean table[]= new boolean[s.length()+1];
	        
	        table[0]=true;
	        
	        for(int i=0;i<table.length;i++){
	            
	            if(table[i]==true){
	                
	                for(String str:wordDict){
	                    if(i+str.length()<table.length && s.substring(i, i+str.length()).equals(str)){
	                        table[i+str.length()]=true;
	                    }
	                }
	                
	            }
	        }
	        
	        return table[table.length-1];
	    }
}
