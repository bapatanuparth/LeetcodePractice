package leetcodeGreedy;
import java.util.*;

//Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
//
//Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

//Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//Output: true
public class HandOfStraight {

	
	 public boolean isNStraightHand(int[] hand, int groupSize) {
	     
		 //check if we can actually divide the array in group size
	        if(hand.length%groupSize!=0)return false;
	        
	        //we use queue to get the minimum element at every iteration
	        Queue<Integer> q= new PriorityQueue<>((a,b)->a-b);
	        //we use map to check if the next element after every minimum element s present or not
	        Map<Integer, Integer> map= new HashMap<>();
	        
	        //store the frequency map of each value
	        //store ascending order of values so we get min to max all values in order
	        for(int i:hand){
	            q.add(i);
	            map.put(i, map.getOrDefault(i,0)+1);
	        }
	            
	        
	        while(!q.isEmpty()){
	            int min= q.poll(); //find out the current minimum value amongst the array
	            
	            for(int i=0;i<groupSize;i++) //check for next K consecutive elements if all the elements are in the arr
	            {   
	                if(!map.containsKey(min+i))return false; //if an element not present return false
	                else{
	                    if(map.get(min+i)==0) //if an element is present but has 0 frequency
	                    {
	                      if(i!=0)return false; //if i!=0 it means for a value > min, we are getting 0 frequency. this is not what we want
	                      else break; //dont go in the loop because the element was already used in the previous group so it is a valid case
	                    } 
	                    else
	                        map.replace(min+i, map.get(min+i)-1); //if frequency >0 , freq--
	                }
	            }
	        }
	        
	        return true;
	        
	        
	        
	    }
}
