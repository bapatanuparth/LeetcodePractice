package leetcodeGreedy;

public class JumpGame {


//	You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//	Return true if you can reach the last index, or false otherwise.

	//VERYYY EASY GREEDY SOLUTION
	 public boolean canJumpGreedy(int[] nums) {
	     
	        int lastGood= nums.length-1;
	        
	        for(int i=nums.length-1;i>=0;i--){
	            
	            if(i+nums[i]>=lastGood){ //of for and index, index+nums[index] goes ahead of the value that is already reachable, we can shift the value already reachble to one that index
	                //i+nums[i] covers all the values of 1/2/3.. up to nums[i] jumps
	                lastGood=i;
	            }
	            
	        }
	        return lastGood==0;
	    }
	
	
	//my solution
	 //using dynamic programming
	  public boolean canJump(int[] nums) {
	        
	        int[] memo= new int[nums.length];
	        return jump(nums, nums[0],0, memo);
	    }
	    
	  //while making each jump, we need to try all possible jumps that can be made from that index element
	  //ex. if nums[i]==3, we can either make 1 / 2 / 3 jumps. 
	  //so we need to try to make these jumps and then recursively check at each index whether any of the jump is leading to the end of array
	    boolean jump(int []nums, int val, int ind, int []memo){
	    	
	        if(ind==nums.length-1) //we reached end, so return true
	            return true;
	        
	        if(memo[ind]==-1)return false;
	            
	        for(int i=val;i>=1;i--){ //val represent the length of the jump that we can make, we try each possible jump distance from longest to 1
	        	//for each jumped distance, we recursively go to the index == prev_index+ i
	            if((ind+i)>=nums.length)continue; //if prev_index+i goes out of range
	            boolean temp=jump(nums, nums[ind+i], ind+i,memo); //else make the jump, to that index element and check recursively if anywhere we reach the end
	            if(!temp)memo[ind+i]=-1; //memoize the indexes that are false for further calls
	            else return true;
	            
	        }
	        return memo[ind]==-1;
	    }
}
