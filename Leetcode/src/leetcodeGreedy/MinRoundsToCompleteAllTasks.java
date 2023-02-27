package leetcodeGreedy;
import java.util.*;

//You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
//
//Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.


//Input: tasks = [2,2,3,3,2,4,4,4,4,4]
//Output: 4
public class MinRoundsToCompleteAllTasks {

	 public int minimumRounds(int[] tasks) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int num:tasks){
	            map.put(num, map.getOrDefault(num, 0)+1);
	        }
	        
	        
	        int sum=0;
	        for(int i:map.values()){ //for each value cases are ->
	           if(i==1)
	               return -1;
	            if(i==2)
	                sum+= 1;
	            else{ //if value>=3, count as much of 3s as you can.
	                sum+= i/3; 
	                if(i%3!=0) // 2 corner cases consider --?
	                	//if i%3==1, ex. i==4, we need 2 2s we have already counted i/3 i.e. 1 so we just do sum++
	                	//if i%3 == 2, ex. i==5, we need 1 3 and 1 2, we have already counted i/3 i.e. 1 so we just do sum++
	                	//for i%3 == 0, its already going to be equal to i/3 directly.
	                    sum++;
	            }
	        }
	        
	        return sum;
	        
	    }
}
