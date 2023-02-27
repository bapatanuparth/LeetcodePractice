package leetcodeStrings;

import java.util.HashMap;
import java.util.Map;


//You are given two strings s and t.
//
//String t is generated by random shuffling string s and then add one more letter at a random position.
//
//Return the letter that was added to t.
public class FindTheDifference {

	//*********************
	//very very easy solution using XOR concept
	  public char findTheDifferenceXOR(String s, String t) {
	        char c = 0;
	        for(char cs : s.toCharArray()) c ^= cs;
	        for(char ct : t.toCharArray()) c ^= ct;
	        return c;
	    }
	  
	  //another easy approach is to sum the ASCII values and then return only the difference
	  char findTheDifferenceSum(String s, String t) 
      {
          int ans=0;
          for(char x: t.toCharArray())
              ans+=x;                          //int+char=>int+ASCII of char
          for (char x: s.toCharArray())
              ans-=x;
          return (char)ans;                    //converting ASCII to char
      }
	
	
	  public char findTheDifference(String s, String t) {
	        
	        Map<Character,Integer> map=new HashMap<>();
	    
	        for(char ch:s.toCharArray()){
	            map.put(ch,map.getOrDefault(ch,0)+1);
	        }
	        for(char ch:t.toCharArray()){
	            if(!map.containsKey(ch))return ch;
	            map.replace(ch,map.get(ch)-1);
	        }
	        //required when all letters from a-z are present
	        //then we need to count the occurrences of each letter and find the extra
	        int count=0;
	        
	        for(int i:map.values()){
	            count++;
	            if(i==-1)break;
	        }
	        for(char ch:map.keySet()){
	            count--;
	            if(count==0)return ch;
	        }
	        
	        return 'a';
	    }
}
