package leetcode1;

import java.util.HashSet;
import java.util.Set;

//You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
//Each character in stones is a type of stone you have. 
//You want to know how many of the stones you have are also jewels.

//Input: jewels = "aA", stones = "aAAbbbb"
//Output: 3

public class JewelsandStones {
	
	//solution one
    public int numJewelsInStones(String jewels, String stones) {
    	int count=0;
    	for(int i=0;i<stones.length();i++)
    		{
    		if(jewels.contains(String.valueOf(stones.charAt(i)))) {
    			count++;
    		}
    		}
    	return count;
    }
    
    //solution two
    public int numJewelsInStones2(String jewels, String stones) {
    	int count=0;
    	Set<Character> set=new HashSet<>();
    	for(int i=0;i<jewels.length();i++)
    		set.add(jewels.charAt(i));
    	for(int i=0;i<stones.length();i++)
    		{
    		if(set.contains(stones.charAt(i))) {
    			count++;
    		}
    		}
    	return count;
    }
}
