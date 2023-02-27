package leetcodeGreedy;

//There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
//
//Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

 

public class GasStation {
	
	
	//Greedy approach
	public int canCompleteCircuitEff(int[] gas, int[] cost) {
        // currentBalance - the current balance we are considering (which has to be >= 0)
        // remainingBalance - the balance of the remaining part (which is <= 0)
        int start = 0, currentBalance = 0, remainingBalance = 0;
       // iterate through each gas station and update the starting point, which takes O(n) time
        for (int i = 0; i < cost.length; i++) {
            // update the current gas balance
            currentBalance += gas[i] - cost[i];
            // if the currently considering balance < 0, we can't move to the next gas station -> the current start is invalid
            if (currentBalance < 0) {
                start = i + 1; // update start to new candidate value
                remainingBalance += currentBalance; // update the negative balance (of the remaining part)
                currentBalance = 0; // reset the currently considering balance
            }
        }
        // at the end, we check whether the positive balance (currentBalance) can compensate the remainingBalance (currentBalance + remainingBalance has to be >= 0)
        return currentBalance + remainingBalance >= 0 ? start : -1;
    }

	//soltuion using DP
	//need to memoize
	 public int canCompleteCircuit(int[] gas, int[] cost) {
	        
	        for(int i=0;i<gas.length;i++){
	            if(can(gas.length,gas,cost,i,1,0)==true)
	                return i;
	        }
	        return -1;
	    }
	    
	    boolean can(int n, int []gas, int [] cost, int i, int start ,int avail){
	        if(start>gas.length)return true;
	        avail=avail+gas[i];
	        if(avail<cost[i])return false;
	        
	        if(can(n,gas,cost,(i+1)%n,start+1,avail-cost[i]))return true;
	        
	        return false;
	    }
}
