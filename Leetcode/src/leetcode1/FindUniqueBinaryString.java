package leetcode1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given an array of strings nums containing n unique binary strings each of length n,
//return a binary string of length n that does not appear in nums. 
//If there are multiple answers, you may return any of them.
public class FindUniqueBinaryString {
	
	
	//Efficient ultra max solution
    public String findDifferentBinaryStringEff(String[] nums) 
    {
        int n = nums.length;
        char[] ans = new char[n];
        
        for(int i=0; i<n;i++)
        {
        
            ans[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        
    //Convert full character array in one string to return it
        return String.valueOf(ans);
    }

	//generate all possible binary numbers
	public static String generateString(String s,String[] nums, int len,Set<String> set) {
		if(s.length()==nums.length && !set.contains(s)) {
			System.out.println(s);
			return s;
		}
		if(len==0)
			return "";
		String str=generateString(s+"0", nums, len-1,set);
		str=str+generateString(s+"1", nums, len-1,set);
		return str;
	}
	
    public String findDifferentBinaryString(String[] nums) {
        return "";
    }
    public static void main(String[] args) {
    	String test[]=new String[] {"111","000","101"};
		Set<String> set=new HashSet<>(Arrays.asList(test));
		System.out.println(generateString("", new String[] {"111","000","101"}, 3,set));
	}
}
