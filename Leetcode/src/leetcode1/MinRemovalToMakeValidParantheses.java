package leetcode1;



//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
//so that the resulting parentheses string is valid and return any valid string.

public class MinRemovalToMakeValidParantheses {

	 public String minRemoveToMakeValid(String s) {
	        int count=0;
	        int start=0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='(')count++;
	            else if (count==0 && s.charAt(i)==')'){
	                start++;
	        }else if(s.charAt(i)==')')count--;
	    }
	        System.out.println(count);
	        StringBuilder sb=new StringBuilder();
	        int i;
	        for(i=0;i<s.length();i++){
	            if(start>0 && s.charAt(i)==')'){
	                start--;continue;
	            }
	            else if (count<0 && s.charAt(i)==')'){
	                count++;
	            }
	            else sb.append(s.charAt(i));
	    }
	        if(start==0 && count ==0)return sb.toString();
	        if(count>0){
	            for(i=sb.length()-1;i>=0;i--){
	                if(sb.charAt(i)=='('){
	                    count--;
	                    sb.deleteCharAt(i);
	                    if(count==0)break;
	            }
	        }
	        }
	        
	        
	     return sb.toString();
	    }
	   
}
