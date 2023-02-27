package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class ValidParantheses {
    public static boolean isValid(String s) {
    	//if(s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}')return false;
    	List<Character> stack=new ArrayList<>();
        for(int i=0;i<s.length();i++) {
        	System.out.println(stack);
        	if(s.charAt(i)=='(')stack.add(')');
        	else if(s.charAt(i)=='[')stack.add(']');
        	else if(s.charAt(i)=='{')stack.add('}');
        	else if (stack.isEmpty() && s.charAt(i)==']')return false;
        	else if (stack.isEmpty() && s.charAt(i)=='}')return false;
        	else if (stack.isEmpty() && s.charAt(i)==')')return false;
        	else if(s.charAt(i)==stack.get(stack.size()-1))stack.remove(stack.size()-1);
        	else if(s.charAt(i)!=stack.get(stack.size()-1))return false;
        }
        if(!stack.isEmpty())return false;
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
	
}
