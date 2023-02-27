package leetCodeArrays2;
import java.util.PriorityQueue;
import java.util.Queue;

//You are given an array of integers stones where stones[i] is the weight of the ith stone.
//
//We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
//
//If x == y, both stones are destroyed, and
//If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
//At the end of the game, there is at most one stone left.
//
//Return the weight of the last remaining stone. If there are no stones left, return 0.

//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation: 
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

public class LastStoneWeight {

	 public int lastStoneWeight(int[] stones) {
	        if(stones.length==1)return stones[0];
	        
	        Queue<Integer> q= new PriorityQueue<>((a,b)->b-a); //arrange stones in descending order
	        
	        for(int i:stones){
	            q.add(i);
	        }
	        
	        while(q.size()>1){
	            int a= q.poll();
	            int b=q.poll(); //take out 2 stones
	            if(a!=b)q.add(Math.max(a-b, b-a)); //if they are not equal add back their difference, repeat the process
	        } 
	            
	        if(q.isEmpty())return 0;
	        return q.poll();
	    }
}
