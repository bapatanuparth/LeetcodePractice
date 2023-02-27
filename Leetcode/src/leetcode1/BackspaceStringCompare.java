package leetcode1;

import java.util.Stack;

//Given two strings s and t, return true if they are equal when both are typed into 
//empty text editors.'#' means a backspace character.

//Input: s = "ab#c", t = "ad#c"
//Output: true
public class BackspaceStringCompare {

	//naive approach using 2 stacks
	 public boolean backspaceCompare(String s, String t) {
	        
	        Stack<Character> st=new Stack<>();
	        Stack<Character> st2=new Stack<>();
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)!='#'){
	                st.push(s.charAt(i));
	            }
	            else if(s.charAt(i)=='#' && !st.isEmpty()){
	                st.pop();
	            }
	        }
	        for(int i=0;i<t.length();i++){
	            if(t.charAt(i)!='#'){
	                st2.push(t.charAt(i));
	            }
	            else if(t.charAt(i)=='#' && !st2.isEmpty()){
	                st2.pop();
	            }
	        }
	       
	    return st.equals(st2);
	    }
	 
	 //another approach using stringbuilder
	 public boolean backspaceCompare2(String S, String T) {
	        String s = getString(S);
	        String t = getString(T);
	        return s.equals(t);
	    }
	    
	    private String getString(String s) {
	        StringBuilder str = new StringBuilder();
	        char[] c = s.toCharArray();
	        for (char ch : c) {
	            if (ch == '#') {
	                if ( str.length() != 0) {
	                    str.deleteCharAt(str.length() - 1);
	                }
	            } else {
	                str.append(ch);
	            }
	        }
	        return str.toString();
	    }
	  
}
