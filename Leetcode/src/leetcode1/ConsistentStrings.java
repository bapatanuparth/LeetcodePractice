package leetcode1;

//You are given a string allowed consisting of distinct characters and an array of 
//strings words. A string is consistent if all characters in the string appear in the
//string allowed.

//Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//Output: 2
public class ConsistentStrings {

	 public int countConsistentStrings(String allowed, String[] words) {
	        boolean flag;
	        int count=0;
	        for(int i =0;i<words.length;i++){
	            flag=true;
	            String s=words[i];
	            for(int j=0;j<s.length();j++){
	                if(allowed.indexOf(s.charAt(j))==-1){
	                    flag=false; break;
	                }  
	            }
	            if(flag){
	                count++;
	            }
	            
	        }
	        return count;
	    }
}
