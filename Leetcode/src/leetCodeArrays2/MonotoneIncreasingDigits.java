package leetCodeArrays2;

import java.util.Stack;

//An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.
//
//Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.

//Input: n = 1234
//Output: 1234

//Input: n = 332
//Output: 299
public class MonotoneIncreasingDigits {

	//using monotonic stack
	 public int monotoneIncreasingDigits(int n) {
	     String str= Integer.toString(n);
	        
	        Stack<Integer> st = new Stack<>(); //maintain a increasing stack
	       // int res=0;
	        for(int i=0;i<str.length();i++){ 
	            int val= str.charAt(i)-'0';
	            
	            if(!st.isEmpty() && st.peek()>val){//if we get a lower value than previous digit, we need to reduce the previous digit by 1 and 
		        	//all the remaining numbers should be changed to 9, as this will be the largest possible monotonic number satisfying the condition
	             
	                while(!st.isEmpty() && st.peek()>val){ //running while loop for cases like 44442 -- we need to trace all 4s back till the first occurrence and reduce it to 3
	                    val=st.pop()-1; //as we need to reduce the digit by 1 to get the highest possible monotonic number
	                    i--; //re adjust the index as we may remove multiple duplicates that were already seen, ex. 3332
	                }
	                st.push(val); //push the reduced value in staack
	                i++;
	                while(i<str.length()){
	                    st.push(9); //make all the remaining digits == 9
	                    i++;
	                }
	            }
	            else{ //if values are in ascending order simply push in stack
	                st.push(val);
	            }
	        }
	        
	        StringBuilder sb= new StringBuilder();
	        while(!st.isEmpty()){
	            sb.append(st.pop());
	        }
	        
	        int res=Integer.parseInt(sb.reverse().toString());
	        return res;
	    }
}
