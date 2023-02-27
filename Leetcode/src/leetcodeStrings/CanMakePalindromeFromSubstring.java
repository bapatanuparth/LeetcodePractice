package leetcodeStrings;

import java.util.ArrayList;
import java.util.List;


//You are given a string s and array queries where queries[i] = [lefti, righti, ki]. We may rearrange the substring s[lefti...righti] for each query and then choose up to ki of them to replace with any lowercase English letter.
//
//If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
//
//Return a boolean array answer where answer[i] is the result of the ith query queries[i].
//
//Note that each letter is counted individually for replacement, so if, for example s[lefti...righti] = "aaa", and ki = 2, we can only replace two of the letters. Also, note that no query modifies the initial string s.

//Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
//Output: [true,false,false,true,true]

//Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
//Output: [false,true]
public class CanMakePalindromeFromSubstring {
	
//	Since we can rearrange the substring, all we care about is the frequency of each character in that substring.

	 private int [][] occurrences; 
	    
	    //function to calculate freuencies of characters in each prefix substring of S
	 
//	 As a preprocess, calculate the accumulate frequency of all characters for all prefixes of the string.
	    public void calcFrequenciesPrefixes(String s){
	        int [][] occurrences= new int[s.length()][26]; //create 2D array to store frequencies of chars in a prefix sum kind of way. 
	        //store character frequency till ith index int the ith 2D array index
	        occurrences[0][s.charAt(0)-'a']=1; 
	        
	        for(int i=1;i<s.length();i++){
	            
	            for(int j=0;j<26;j++){
	                occurrences[i][j]=occurrences[i-1][j]; //copy all the frequencies till previous index 
	            }
	            
	            occurrences[i][s.charAt(i)-'a']=occurrences[i][s.charAt(i)-'a']+1; //+1 to the new character frequency to the previous value
	        }
	        
	        this.occurrences=occurrences; //at the end, we have 2D occurrences array filled with character frequency of each prefix substring of the main string
	              
	    }
	    
//	    Count the number of odd frequencies, there can be at most one odd frequency in a palindrome.
	    public boolean isPossiblePalindrome(int left, int right, int k){
	        
	        int oddFrequencies=0;
	        if(left==0){ //means check for substring (0, right) if it can be made a palindrome with K character changes
	            
	            for(int i=0;i<26;i++){
	                if(occurrences[right][i]%2==1) //count how many odd frequency values in the substring
	                    oddFrequencies++;
	            }
	        }else{ //means check for substring (left, right) if it can be made a palindrome with K character changes
	            for(int i=0;i<26;i++){
	                if((occurrences[right][i]-occurrences[left-1][i])%2==1)
	                    oddFrequencies++;
	            }
	        }
	        
	        return oddFrequencies/2<=k; //if oddfrequency/2 < k 
	        
	    }
	    
	    
	    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
	        
	        List<Boolean> res= new ArrayList<>();
	        
	        calcFrequenciesPrefixes(s);
	        
	        for(int i=0;i<queries.length;i++){
	            res.add(isPossiblePalindrome(queries[i][0],queries[i][1],queries[i][2])); //run for whole queries array
	        }
	        
	        return res;
	    }
}
