package leetcodeDynamicProgramming;

public class PalindromicSubstrings {

	//use the logic of finding palindromic substrings used for longest palindrome substring
	 public int countSubstrings(String s) {
	        char[] str= s.toCharArray();   
	        int n=s.length();
	        
	        //expand taking 1 character as center on both sides till the word so formed is a palindrome
	        //odd length palindrome
	        int count=0;
	        for(int i=0;i<str.length;i++){
	            int hi=i, low=i;
	            while(low>=0 && hi<str.length && str[low]==str[hi]){
	                hi++;
	                low--;
	                count++;
	            }
	        }
	        
	        //expand taking 2 characters in the center on both sides till we keep getting palindrome
	        //even length palindrome
	        for(int i=0;i<str.length;i++){
	            int low=i, hi=i+1;
	            while(low>=0 && hi<str.length && str[low]==str[hi]){
	                hi++;
	                low--;
	                count++;
	            }
	        }
	        
	        return count;
	    }
}
