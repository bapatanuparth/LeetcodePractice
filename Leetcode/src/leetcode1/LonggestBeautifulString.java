package leetcode1;

import java.util.Stack;

//A string is considered beautiful if it satisfies the following conditions:
//
//Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
//The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).

public class LonggestBeautifulString {
	class Solution {
	    public int longestBeautifulSubstring(String s) {
	        
	        Stack<Character> stack=new Stack<>();
	        int maxLen=0;
	        
	        
	        for(int i=0;i<s.length();i++)
	        {
	            if(stack.isEmpty())
	            {
	                if(s.charAt(i)=='a')
	                      {stack.push('a');continue;}
	                else{
	                    continue;
	                }
	            }else{
	                char c=s.charAt(i);
	                if(c=='a')
	                {
	                    if(stack.peek()=='a')
	                    {
	                        stack.push(c);
	                    }else{
	                        if(stack.peek()=='u')
	                        maxLen=Math.max(stack.size(),maxLen);
	                        stack.clear();
	                        stack.push('a');
	                    }
	                }else if(c=='e')
	                {
	                    if(stack.peek()=='e' || stack.peek()=='a')
	                    {
	                        stack.push(c); 
	                    }else{
	                        stack.clear();
	                    }
	                }else if(c=='i')
	                {
	                    if(stack.peek()=='e' || stack.peek()=='i')
	                    {
	                        stack.push(c);
	                    }else{
	                        stack.clear();
	                    }
	                }else if(c=='o'){
	                    
	                    if(stack.peek()=='o' || stack.peek()=='i')
	                    {
	                        stack.push(c);
	                    }else{
	                        stack.clear();
	                        continue;
	                    }
	                    
	                }else if(c=='u')
	                {
	                    if(stack.peek()=='o' || stack.peek()=='u')
	                    {
	                        stack.push(c);
	                        maxLen=Math.max(stack.size(),maxLen);
	                        
	                    }else{
	                        stack.clear();
	                    }
	                        
	                }
	            }
	            
	            
	            
	            
	        }
	        return maxLen;
	    }
	}
}
