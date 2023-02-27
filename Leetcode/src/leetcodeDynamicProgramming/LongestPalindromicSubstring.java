package leetcodeDynamicProgramming;

//Given a string s, return the longest palindromic substring in s.

//Input: s = "babad"
//Output: "bab"

//Input: s = "cbbd"
//Output: "bb"
public class LongestPalindromicSubstring {

	 public String longestPalindrome(String s) {
	        
		 //we go on checking each character and go on expanding keeping the character as center and keep checking 
		 //if char+1 == char-1
		 //we do this till there is a palindrome, 
	        int n= s.length();
	        char[] str= s.toCharArray();
	        String res="";
	        int resLen=0;
	        
	        //palindrome can be 2 types, even length =="cbbc" or odd length== "bab"
	        //write 2 cases to check for both and take max while checking
	        
	        
	        //odd length palindrome
	        for(int i=0;i<n;i++){
	            
	            int h=i, l=i; //initially high and low point to the ith character
	            while(l>=0 && h<n && str[h]==str[l]){ //we check whether char+1 == char-1 
	                h++;
	                l--;
	            }
	     
	            int m= h-l-1; //calculate length of the substring which is palindrome keeping ith element on the center
	            if(m>resLen){
	                 res=s.substring(l+1,h); //update res if its max
	                resLen=m;
	            }
	           
	        }
	        
	        //even length palindrome
	        for(int i=0;i<n;i++){
	            
	            int h=i+1, l=i; //same case ass earlier, here we take 2 chars in the middle as center of palindrome as an even length palindrome will have 2 characters in center
	            while(l>=0 && h<n && str[h]==str[l]){
	                h++;
	                l--;
	            }
	            int m= h-l-1;
	            if(m>resLen){
	                 res=s.substring(l+1,h);
	                resLen=m;
	            }
	           
	        }
	        
	        return res;
	    }
}
