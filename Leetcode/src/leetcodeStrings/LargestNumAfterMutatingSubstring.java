package leetcodeStrings;

//You are given a string num, which represents a large integer. You are also given a 0-indexed integer array change of length 10 that maps each digit 0-9 to another digit. More formally, digit d maps to digit change[d].
//
//You may choose to mutate a single substring of num. To mutate a substring, replace each digit num[i] with the digit it maps to in change (i.e. replace num[i] with change[num[i]]).
//
//Return a string representing the largest possible integer after mutating (or choosing not to) a single substring of num.
//
//A substring is a contiguous sequence of characters within the string.

//Input: num = "132", change = [9,8,5,0,3,6,4,2,6,8]
//Output: "832"
public class LargestNumAfterMutatingSubstring {

	 public String maximumNumber(String num, int[] change) {
	        StringBuilder output = new StringBuilder();
	        boolean on = false;
	        boolean used = false;
	        int cur, alt;
	        for (char c : num.toCharArray())
	        {
	            cur = c - '0';
	            alt = change[cur];
	            if (alt > cur && (!used || on))
	            {
	                output.append(alt);
	                used = true;
	                on = true;
	                continue;
	            }
	            if (alt < cur && on)
	            {
	                on = false;
	            }
	            output.append(c);
	        }
	        return output.toString();
	    }
}
