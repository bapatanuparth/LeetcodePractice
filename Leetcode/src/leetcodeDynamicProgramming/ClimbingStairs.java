package leetcodeDynamicProgramming;

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
public class ClimbingStairs {

	public int climbStairs(int n) {

        int [] memo= new int[n+1]; //to memoize the solution
        
        return memoize(n, memo); 
           
    }
    
    int memoize(int n, int [] memo){
        if(n<0) return 0;
        if(n==0)return 1;
        
        if(memo[n]!=0)return memo[n]; //memoize solution for efficiency
        
        memo[n]= memoize(n-1, memo)+memoize(n-2, memo); //get number of ways we can reach by one steps and by taking 2 steps
        return memo[n];
    }
}
