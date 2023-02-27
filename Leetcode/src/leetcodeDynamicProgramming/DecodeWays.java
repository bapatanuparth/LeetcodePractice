package leetcodeDynamicProgramming;

//A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
//Given a string s containing only digits, return the number of ways to decode it.
//
//The test cases are generated so that the answer fits in a 32-bit integer.

//Input: s = "226"
//Output: 3
public class DecodeWays {

	//tabulation solution
	  public int numDecodings(String s) {
	        
	        int dp[] = new int [s.length()];
	        int val=0;
	        
	        for(int i=0;i<dp.length;i++){
	            val=0;
	            int a = s.charAt(i)-'0'; //get number at ith position
	            
	            if(a!=0) //if number != 0, update value to i-1 th value 
	                val+=(i==0)?1:dp[i-1];
	            
	            if( i>0 && (int)(s.charAt(i-1)-'0')!=0 ){ //also now we need to check if last 2 numbers form <= 26
	                a= (int)(s.charAt(i-1)-'0')*10+a; //calculate the number formed by i-1 th and ith element
	                if(a<=26) //if number < 26
	                    val+=(i>1)?dp[i-2]:1; //the new possible value will be == the no. of possible ways for i-2 th element
	            }
	            dp[i]=val;
	        }
	        
	        return val;
	    }
}
