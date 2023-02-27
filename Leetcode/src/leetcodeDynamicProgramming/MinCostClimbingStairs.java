package leetcodeDynamicProgramming;

//You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
//
//You can either start from the step with index 0, or the step with index 1.
//
//Return the minimum cost to reach the top of the floor

//Input: cost = [1,100,1,1,1,100,1,1,100,1]
//Output: 6
//Input: cost = [10,15,20]
//Output: 15
public class MinCostClimbingStairs {

	//using tabulation
	 public int minCostClimbingStairs(int[] cost) {
		    
	        int [] minCost = new int[cost.length];
	        
	        minCost[0]=cost[0]; //min possible cost for 0th and 1st number of array is the same number
	        minCost[1]=cost[1];
	        
	        for(int i=2;i<cost.length;i++){ //for all the next numbers, min possible cost is either cost[i] + num[i-1] or cost[i] + num[i-2] 
	            minCost[i]= cost[i] + Math.min(minCost[i-1], minCost[i-2]); //take minimum of i-1 or i-2 and add cost[i] to it. this is the min possible cost for ith position.
	        }
	        
	        //after loop ends, we have min possible cost to reach each place of the index
	        return Math.min(minCost[cost.length-2], minCost[cost.length-1]); //our answer can be the last or second 
	        //last or second last number as , we can either take 1 step or 2 steps to reach the end of the array
	    
	    }
}
