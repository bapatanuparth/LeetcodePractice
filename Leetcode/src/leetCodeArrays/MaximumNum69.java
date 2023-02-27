package leetCodeArrays;

import java.util.ArrayList;
import java.util.List;

//You are given a positive integer num consisting only of digits 6 and 9.
//
//Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

public class MaximumNum69 {
	
	//genius solution
	 public int maximum69Number (int num) {
	        
	        int numToBeAdded = 0, temp = 0, tempNum = num;
	        
	        while(tempNum > 0) {
	            if(temp == 0) {
	                temp = 1;
	            } else {
	                temp *= 10;
	            }
	            if((tempNum % 10) == 6) {
	                numToBeAdded = 3 * temp;
	            }
	            
	            tempNum /= 10;
	        }
	        
	        int result = num + numToBeAdded; 
	        return result;
	    }
	 
	 
	 //my solution -- not so genius 
	  public int maximum69Number2 (int num) {
	        int x=num;
	        List<Integer> arr=new ArrayList<>();
	        while(x>0){
	            arr.add(x%10);
	            x=x/10;
	        }
	        System.out.println(arr);
	        for(int i=arr.size()-1;i>=0;i--){
	            if(arr.get(i)==6){
	                arr.set(i,9);
	                break;
	            }
	        }
	        System.out.println(arr);
	        int mul=1,sum=arr.get(0);
	        for(int i=1;i<arr.size();i++){
	            sum+=10*mul*arr.get(i);
	            System.out.println(sum);
	            mul*=10;
	        }
	        return sum;  
	    }
}
