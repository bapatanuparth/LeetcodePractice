package leetcodeStrings;

import java.util.Stack;

//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
//
//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"

//	Input: s = "3[a2[c]]"
//	Output: "accaccacc"
public class DecodeString {

	 public String decodeString(String s) {
	        Stack<String> st1= new Stack<>(); //string before [
	        Stack<Integer> st2 = new Stack<>(); //count before [
	        
	        int count=0;
	        String res="";
	        
	        for(int i=0;i<s.length();i++){
	            char ch=s.charAt(i);
	            
	            if(ch>='0' && ch<='9'){
	                count=count*10 + ch-'0'; //count number before [
	                
	            }
	            else if(ch=='['){
	                st1.push(res); //push string value till now into stack
	                st2.push(count); //push the no. of times the upcoming string after [ to be repeated
	                count=0;
	                res=""; //this ensures that now we only consider the string ahead of [ for looping
	               
	            }
	            else if(ch==']'){
	                String temp= st1.pop(); //get the string till now
	                int time=st2.pop();
	                
	                while(time-->0){
	                    temp+=res; //append the string between [ ] to the previous string in loop == #count
	                }
	                res=temp; //update the previous value with current changes after running loop
	                
	            }
	            else{
	                res+= Character.toString(s.charAt(i)); //if plane string, do nothing, build string to add to result
	            }
	        }
	        return res;
	    }
}
