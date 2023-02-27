package leetcode1;

import java.util.HashMap;
import java.util.Map;


//convert a given roman string to integer
//certain romans like IV, XL, CD etc. use subtraction and not addition. 
//
public class romanToInt {
	
	public static Map<String, Integer> createMap(){
		Map<String,Integer> roman=new HashMap<>();
	    roman.put("I", 1);
	    roman.put("V", 5);
	    roman.put("X", 10);
	    roman.put("L", 50);
	    roman.put("C", 100);
	    roman.put("D", 500);
	    roman.put("M", 1000);
	    roman.put("IV", 4);
	    roman.put("IX", 9);
	    roman.put("XL", 40);
	    roman.put("XC", 90);
	    roman.put("CD", 400);
	    roman.put("CM", 900);
	    return roman;
	}
	
	
    public static int romanToInt(String s) {
     Map<String,Integer> roman=createMap();
     int sum=0;
     for(int i=0;i<s.length();i++) {
    	 
    	 if(i!=s.length()-1 && roman.containsKey(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))) {
    		 sum=sum+roman.get(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)));
    		 i++;
    	 }
    	 else sum=sum+roman.get(String.valueOf((s.charAt(i))));
     }
     return sum;
    }
    
    public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
