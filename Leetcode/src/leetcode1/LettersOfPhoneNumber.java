package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a string containing digits from 2-9 inclusive, 
//return all possible letter combinations that the number could represent. Return the answer in any order.
public class LettersOfPhoneNumber {
	
	public static List<String> getCombination(String s,List<String> ls,int n, List<String>op){
		if(n==ls.size()) {
			op.add(s);
			return op;
		}
		for(int i=0;i<ls.get(n).length();i++) {
			 getCombination(s+ls.get(n).charAt(i),ls,n+1, op);
		}
		return op;
	}
	
    public static List<String> letterCombinations(String digits) {
    	Map<String, String> map=new HashMap<>();
    	List<String>ls=new ArrayList<String>();
    	List<String>op=new ArrayList<String>();
//    	if(digits.isEmpty())return op;
//    	map.put("2", "abc");
//    	map.put("3", "def");
//    	map.put("4", "ghi");
//    	map.put("5", "jkl");
//    	map.put("6", "mno");
//    	map.put("7", "pqrs");
//    	map.put("8", "tuv");
//    	map.put("9", "wxyz");
//    	for(int i=0;i<digits.length();i++) {
//    		ls.add(""+map.get(""+digits.charAt(i)));
//    	}
    	String []codes={"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	for(int i=0;i<digits.length();i++) {
    		ls.add(codes[digits.charAt(i)-'0']);
    	}
    	return getCombination("",ls,0,op);
        
    }
	
    public static void main(String[] args) {
		List<String> ls= new ArrayList<>(Arrays.asList(new String[] {"abc","def","wxyz"}));
		List<String>op=new ArrayList<String>();
		System.out.println(letterCombinations("23"));
	}
}
