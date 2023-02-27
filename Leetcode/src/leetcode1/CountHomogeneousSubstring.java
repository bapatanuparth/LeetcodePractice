package leetcode1;

import java.util.HashMap;
import java.util.Map;

//Given a string s, return the number of homogenous substrings of s.
//		Since the answer may be too large, return it modulo 109 + 7.

//Input: s = "abbcccaa"
//Output: 13
//Explanation: The homogenous substrings are listed as below:
//"a"   appears 3 times.
//"aa"  appears 1 time.
//"b"   appears 2 times.
//"bb"  appears 1 time.
//"c"   appears 3 times.
//"cc"  appears 2 times.
//"ccc" appears 1 time.
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
public class CountHomogeneousSubstring {

	class Solution {
		
		//effective solution
		 public int countHomogenousEff(String s) {
		       int MOD = 1_000_000_007;
		        char[] temp = s.toCharArray();
		        long ans =0;
		        int i =0;
		        while(i<temp.length){
		            int j =i;
		            while(i<temp.length && temp[i] == temp[j]){
		                i++;
		                }
		            System.out.println(i);
		            long count = i-j;
		            ans = ans+ ((count*(count+1))/2);

		             }
		    return (int)(ans % MOD);
		}
		 
		
		
	    public int countHomogenous(String s) {
	        Map<Character, Long> map=new HashMap<>();
	        final int MOD=1000000007;
	        int prev=0, next=1;
	        if(s.length()==1)return 1;
	        map.put(s.charAt(0),(long) 0);
	        for(int i=1;i<s.length();i++){
	            
	            if(s.charAt(i-1)!=s.charAt(i)){
	                if(!map.containsKey(s.charAt(i)))
	                    map.put(s.charAt(i),(long) 0);
	                long temp=((i-1)-prev)+1;
	                temp=(temp*(temp+1)/2);
	                long value=map.get(s.charAt(i-1));
	                map.replace(s.charAt(i-1), value+temp);
	                prev=i;
	            }
	            if(i==s.length()-1){
	                long temp=((i)-prev)+1;
	                System.out.println(temp);
	                temp=(temp*(temp+1)/2);
	                System.out.println(temp%MOD);
	                long value=map.get(s.charAt(i-1));
	                map.replace(s.charAt(i-1), value+temp);
	            }    
	        }
	        long sum=0;
	         for (Long val : map.values())
	            sum+=(val);
	    return (int)(sum %MOD);
	    }
	}
}
