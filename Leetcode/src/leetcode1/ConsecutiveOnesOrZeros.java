package leetcode1;


//Given a binary string s, return true if the longest contiguous segment of 1's is strictly longer than the
//longest contiguous segment of 0's in s, or return false otherwise.
//Input: s = "1101"
//Output: true
public class ConsecutiveOnesOrZeros {

	 public boolean checkZeroOnes(String s) {
	        int zeros=0;
	        int ones=0;
	        int i=0;
	        while(i<s.length()){
	            int countz=0;
	            int counto=0;
	            int j=i;
	            while(i<s.length() && s.charAt(i)==s.charAt(j)){
	                if(s.charAt(j)=='1')counto++;
	                else if(s.charAt(j)=='0')countz++;
	                i++;
	            }
	            zeros=Math.max(countz,zeros);
	            ones=Math.max(counto,ones);
	        }
	        return ones>zeros;

	 }
}
	 
