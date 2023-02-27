package leetCodeArrays2;
import java.util.*;

//Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
//
//Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.

public class FinalPriceWithDiscount {

	//efficient solution using monotonic stack
	
	 public int[] finalPricesEff(int[] prices) {
	       
		 	//maintain a stack- add number indices to stack if the new number > old number
	        Stack<Integer> st= new Stack<>();
	        
	        for(int i=0;i<prices.length;i++){
	            
	        	//while the value at stack top > new value, keep updating prices array and popping the stack
	            while(!st.isEmpty() && prices[i]<=prices[st.peek()]){ //while new number < stack.peek() --> update the array with difference
	                prices[st.peek()]=prices[st.peek()]-prices[i];	//doing in while because stack holds values in ascending order
	                st.pop();
	            }
	         st.push(i);   
	        }   
	        
	        return prices;
	    }
	
	
	//brute force based on given information
	public int[] finalPrices(int[] prices) {
        int[] res= new int [prices.length]; 
        
        boolean flag;
        for(int i=0;i<prices.length;i++){
            
            flag=true;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    res[i]=prices[i]-prices[j];
                    flag=false;
                    break;
                }
            }
            
            if(flag)res[i]=prices[i];
        }
        
        return res;
    }
}
