package leetcode1;

import java.util.Stack;

//give min insertions required to balance paranthese
//Any left parenthesis
//'(' must have a corresponding two consecutive right parenthesis '))'.

public class MinInsertiontoBalanceParanthese {
    public static int minInsertions(String s) {
        int result=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='(')
        		st.push('(');
        	else if(i+1<s.length() && s.charAt(i)==')' && s.charAt(i+1)==')') {
        		if(!st.isEmpty())st.pop();
        		else if(st.isEmpty()) {
        			result=result+1;
        		}
        		i++;
        	}
        	else if(i+1<s.length() && s.charAt(i)==')' && s.charAt(i+1)!=')') {
        		if(!st.isEmpty()) {
        			st.pop();result=result+1;
        		}
        		else if(st.isEmpty())result=result+2;
        	}
        	else if(i+1>=s.length() && s.charAt(i)==')') {
        		if(!st.isEmpty()) {
        			st.pop();result=result+1;
        		}
        		else if(st.isEmpty())result=result+2;
        	}
        }
        int temp=st.size()*2;
        return result+temp;
    }
    
    public static void main(String[] args) {
		System.out.println(minInsertions("))))))"));
	}
}
