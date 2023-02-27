package leetCodeArrays;

import java.util.ArrayDeque;
import java.util.Deque;


//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is 
//the number of days you have to wait after the ith day to get a warmer temperature.
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
public class DailyTemperatures {

//	Monotonic stacks are a good option when a problem involves comparing the size of numeric elements, with their order being relevant.
	 public int[] dailyTemperatures(int[] temperatures) {
	        
		 //monotonic stack implementation
		 //keep stack in one particular order
	        Deque<Integer> st= new ArrayDeque<>();
	        int[] answer= new int[temperatures.length];
	        
	        for(int currday=0;currday<temperatures.length;currday++){
	            int temp= temperatures[currday];
	            
	            //while current day is warmer than the previous day, pop the stack and add the index difference to answer
	          //if current day is colder than the previous day, it wont go in loop and we just add it to stack
	            //so stack is maintained in order as lowest element is the warmest and top is the coldest
	            while(!st.isEmpty() && temperatures[st.peek()] < temp){
	                int prevDay= st.pop();
	                //Set answer[prevDay] equal to the number of days that have passed between prevDay and the current day,
	                answer[prevDay]=currday-prevDay;
	            }
	            //store indexes of the elements to stack to be able to count the difference in days
	            
	            st.push(currday);
	        }
	        return answer;
	       
	    }
}
