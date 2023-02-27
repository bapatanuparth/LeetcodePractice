package leetCodeArrays;
import java.util.*;

//We are given an array asteroids of integers representing asteroids in a row.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction 
//(positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
//If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
public class AsteroidCollision {

	 public int[] asteroidCollision(int[] asteroids) {
	        Stack<Integer> st= new Stack<>();
	       
	        for(int ast:asteroids){
	                
	            boolean push =true;
	                
	            while(!st.isEmpty() && ast<0 && st.peek()>0){
	                int peekAbs=Math.abs(st.peek()); 
	                if(peekAbs>=-ast){
	                    push=false;
	                    if(peekAbs==-ast)
	                        st.pop();
	                    break;
	                }else{
	                    st.pop();
	                }
	            }
	            if(push)
	                st.push(ast);
	        }
	        
	        int [] res= new int[st.size()];
	        for(int i=res.length-1;i>=0;i--){
	            res[i]=st.pop();
	        }
	        return res;
	        
	    }
}
