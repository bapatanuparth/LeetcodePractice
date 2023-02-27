package leetcodeStrings;

import java.util.Stack;

public class MinAddToMakeValidParantheses {
	
	//efficient
//	Keep track of the balance of the string: the number of '(''s minus the number of ')''s. 
//A string is valid if its balance is 0, plus every prefix has non-negative balance.
	 public int minAddToMakeValidEff(String S) {
	        int ans = 0, bal = 0;
	        for (int i = 0; i < S.length(); ++i) {
	            bal += S.charAt(i) == '(' ? 1 : -1;
	            // It is guaranteed bal >= -1
	            if (bal == -1) {
	                ans++;
	                bal++;
	            }
	        }
			return bal+ans;
	 }

	 public int minAddToMakeValid(String s) {
	        Stack<Character> st= new Stack<>();
	        int count=0;
	        for(char ch:s.toCharArray()){
	            if(ch=='('){
	                st.push(')');
	            }
	            else if(ch==')'){
	                if(!st.isEmpty()){
	                    st.pop();
	                }else{
	                    count++;
	                }
	            }
	        }
	        count+=st.size();
	        return count;
	    }
}
