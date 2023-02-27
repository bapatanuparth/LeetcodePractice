package leetcode1;

//Given a binary string s, return the number of substrings with all characters 1's.
//		Since the answer may be too large, return it modulo 109 + 7.

//Input: s = "0110111"
//Output: 9

public class NumberofSubstringswith1s {

	    public int numSub(String s) {
	        int res=0;
	        long count=s.charAt(0)-'0';
	        final int MOD = (int)(Math.pow(10,9)+7);
	        for(int i=1; i< s.length();i++){
	            if(i==s.length()-1 && s.charAt(i)=='1'){
	                count++;
	                count=(count+1)*count/2;
	                res=(int)((res+count)%MOD);
	                count=0;
	            }
	            
	            else if(s.charAt(i-1)=='0' && s.charAt(i)=='1'){
	                count++;
	            }
	            else if(s.charAt(i-1)=='1' && s.charAt(i)=='1'){
	                count++;
	            }
	            else if(s.charAt(i-1)=='1' && s.charAt(i)=='0'){
	                count=(count+1)*count/2;
	                res=(int)((res+count)%MOD);
	                count=0;
	            }
	            
	        }
	    return res;
	        
	    }

}
