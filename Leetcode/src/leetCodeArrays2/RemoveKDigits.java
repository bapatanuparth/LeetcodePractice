package leetCodeArrays2;
import java.util.*;
//really good problem
//monotonic stack


//Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
//Input: num = "1432219", k = 3
//Output: "1219"

//Input: num = "10200", k = 1
//Output: "200"
public class RemoveKDigits {

	
	 public String removeKdigits(String num, int k) {
	        if(k==num.length())return "0";//if k==length, we can remove all elements and hence num == 0
	        
	        Stack<Integer> st= new Stack<>(); //we will create resultant string in this monotonic stack
	        int temp=k; //use it to count how many numbers we have removed till now
	        for(int i=0;i<num.length();i++){
	            
	            while(!st.isEmpty() && temp!=0 && num.charAt(i)-'0'<st.peek()) //if number from string < number from stack, st.pop().
	            {
	                st.pop();
	                temp--;
	            }
	            //we will keep only the lowest possible numbers in stack in their ascending order so at the end we have our desired num seq in stack
	            st.push(num.charAt(i)-'0');
	            
	            
	        }
	        
	        //in case of i/p like 12345 == previous loop to remove stack elelements wont run. 
	        //so we need this loop to make sure that we are removing k elements in total. we remove highest k of those
	        if(temp>0){
	            while(temp>0){
	                st.pop();
	                temp--;
	            }
	        }
	        
	        StringBuilder sb= new StringBuilder(); //create o/p string
	        while(st.size()>0){
	            sb.append(st.pop());
	        }
	        
	        //to remove leading zeroes of numbers such as 00200 etc.
	        sb=sb.reverse();
	        int count=0;
	        for(int i=0;i<sb.length()-1;i++){
	            if(sb.charAt(i)=='0')
	                count++;
	            else break;
	        }
	        
	       return sb.substring(count,sb.length());//send substring after removing leading zeros
	       
	    }
}
