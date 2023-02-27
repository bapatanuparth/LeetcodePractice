package leetCodeArrays2;

import java.util.HashMap;
import java.util.Map;

//There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
//
//Given the array answers, return the minimum number of rabbits that could be in the forest.

//Input: answers = [1,1,2]
//Output: 5

//Input: answers = [10,10,10]
//Output: 11

public class RabbitsInForest {

	 public int numRabbits(int[] answers) {
	        Map<Integer, Integer> map = new HashMap();
	        
	        int count=0;
	        for(int ans:answers){
	            
	            if(ans==0) //if rabbit ans is 0 then simply add 1 rabbit to the count.
	                count+=1;
	            else if(!map.containsKey(ans)){
	                map.put(ans,ans); //Simply put each Rabbit answer as key and value in map.
	                count+=ans+1;  //Since there could be minimum ans+1 rabbit, add it in final count.
	            }
	            else{
	                map.put(ans, map.get(ans)-1); //reduce the freq if same answer comes and remove it from map if freq becomes zero.
	                if(map.get(ans)==0)
	                    map.remove(ans);
	            }
	        }
	        return count;
	    }
}
