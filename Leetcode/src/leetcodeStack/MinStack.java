package leetcodeStack;
import java.util.*;
import javafx.util.Pair;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.

public class MinStack {

	//we create a stack of pair
	//the pair will have current value and the smallest value till now
	  Stack<Pair<Integer, Integer>> st;

	    public MinStack() {
	        st= new Stack<>();
	    }
	    
	    //while pushing any new element we create a pair, we check for smallest value till now and the current value
	    //we update the stack with current value and smallest value pair
	    //hence , we can find the smallest value after any pops in O(1) time
	    public void push(int val) {
	        int t= Integer.MAX_VALUE;
	        
	        if(!st.isEmpty())
	            t=st.peek().getValue();
	        Pair<Integer, Integer> p= new Pair<>(val, Math.min(val, t));
	        st.push(p);
	        
	    }
	    
	    public void pop() {
	        st.pop();
	                
	    }
	    
	    //pair has 2 functions- getKey and getValue that allow to get key/value easily
	    public int top() {
	        return st.peek().getKey();
	        
	    }
	    
	    public int getMin() {
	        return st.peek().getValue();
	    }
}
