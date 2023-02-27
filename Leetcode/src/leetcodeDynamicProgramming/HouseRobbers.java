package leetcodeDynamicProgramming;

import java.util.Arrays;

public class HouseRobbers {
	//tabulation solution
	  public int robTab(int[] nums) {
	       if(nums == null || nums.length == 0)
	            return 0;
	        if(nums.length == 1)
	            return nums[0];
	        if(nums.length == 2)
	            return Math.max(nums[1], nums[0]);
	        
	        
	        int[] dp = new int[nums.length];
	        dp[0] = nums[0];
	        dp[1] = Math.max(nums[1], nums[0]);
	        for(int i = 2; i < dp.length ; i++) {
	            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
	        }
	        return dp[dp.length-1];
	        
	    }
	
	

	//memoized solution
//	So we have two choices for every house:-
//
//	we can rob the current ith house then we have to consider the next (i+2)th house
//	we ignore the current house then we can check for adjacent house i.e. (i+1)th house
//	As our problem is now choice picking we can easily implement DP here.
	 public int robMemo(int[] nums) {
	       // System.out.println(nums.length);
	        int [] dp= new int[nums.length];
	        Arrays.fill(dp, -1);
	        return robHouse(nums,0,dp);
	        
	    }
	    
	    int robHouse(int []nums, int i, int [] dp){
	       if(i>=nums.length)
	           return 0;
	       
	       if(dp[i] != -1) return dp[i]; //return memoized value if it is already present
	        int ignoreCurrent = robHouse(nums, i+1, dp); //case 2: we ignore current
	        int takeCurrent = nums[i] + robHouse(nums, i+2, dp); //case 1: we choose current to rob
	        
	        dp[i] = Math.max(ignoreCurrent, takeCurrent); //save the max of 2 as we want to maximize the robbed value
	        return dp[i];
	    }
	
	
	
	//solution without memoization gives TLE
	  int max= 0;
	    public int rob(int[] nums) {
	        System.out.println(nums.length);
	        robHouse(nums,0,0);
	        return max;
	    }
	    
	    void robHouse(int []nums, int i, int sum){
	        if(sum>max){
	           // System.out.println(sum);
	            max=sum;
	        }
	        
	        for(;i<nums.length;i++){
	            sum=sum+nums[i];
	            robHouse(nums, i+2, sum);
	            sum=sum-nums[i];
	        }
	        return;
	    }
}
