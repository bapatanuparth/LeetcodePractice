package leetcode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a unix-like path, simplify it to canonical path structure based on rules
//Input : /a/./b/../../c/
//Output : /c
//
//Input : /a/..
//Output:/

public class SimplifyPath {
	
	//works for string type inputs
	public String simplifyPath2(String path) {
		String[] str=path.split("/");
		Stack<String> stack=new Stack<>();
		for(int i=0;i<str.length;i++) {
			String t=str[i];
			if(!t.equals("..") && !t.equals(".") && !t.equals("")) {
				stack.push("/"+t);
			}
			else if(t.equals(".."))
				if(!stack.isEmpty())stack.pop();
		}
		
		String result="";
		while(!stack.isEmpty())
			result=stack.pop()+result;
		return result.equals("")?"/":result;
	}
	

	//this code doesnt work for paths that have strings.
	//only works for paths given by characters
    public static String simplifyPath(String path) {
    	String  res="/";
    	List<Character> stack=new ArrayList<>();
    	//stack.add('/');
    	for(int i=0;i<path.length();i++) {
    		if(path.charAt(i)!='/' && path.charAt(i)!='.') {
    			stack.add(path.charAt(i));
    		}
    		if(path.charAt(i)=='/')continue;
    		if(path.charAt(i)=='.' && i+1<path.length() && path.charAt(i+1)=='.') {
    			if(stack.size()==0)continue;
    			else stack.remove(stack.size()-1);
    		}
    	}
    	System.out.println(stack);
    	
    	for(int i=0;i<stack.size();i++) {
    		if(i==stack.size()-1)res=res+stack.get(i);
    		else res=res+stack.get(i)+"/";
    	}
    	return res;   
    }
    
    public static void main(String[] args) {
		System.out.println(simplifyPath("/a/../"));
	}
}
