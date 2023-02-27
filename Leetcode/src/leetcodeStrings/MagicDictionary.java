package leetcodeStrings;
import java.util.*;
//implement magic dictionary

//Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
//
//Implement the MagicDictionary class:
//
//MagicDictionary() Initializes the object.
//void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
//bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.



public class MagicDictionary {

	 List<String> arr;
	   
	    public MagicDictionary() {
	        arr= new ArrayList<>();
	    }
	    
	    public void buildDict(String[] dictionary) {
	        for(String s:dictionary){
	            arr.add(s);
	        }
	    }
	    
	    public boolean search(String searchWord) {
	       for(String s:arr){
	           if(checkString(s,searchWord))return true;
	       }
	       // checkString("hello", "hhllo");
	        return false;
	        
	    }
	    
	    public boolean checkString(String s1, String check){
	        int count=0;
	        if(s1.equals(check))return false;
	        if(s1.length()!=check.length())return false;
	        else{
	            for(int i=0;i<s1.length();i++){
	                if(s1.charAt(i)!=check.charAt(i)){
	                    count++;
	                }
	                if(count>1)return false;
	            }
	            return true;
	        }
	    }
}
