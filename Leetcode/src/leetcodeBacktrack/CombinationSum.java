package leetcodeBacktrack;
import java.util.*;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
public class CombinationSum {

	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> ans=  new ArrayList<>();
	        List<Integer> temp = new ArrayList<>();
	        combi(ans, temp, candidates, target,0, 0);
	        return ans;
	    }
	    
	    void combi(List<List<Integer>> ans, List<Integer> temp, int [] candi, int target,int i, int curr){
	        if(curr==target){ //if we reach sum ==target, add the list in the answer
	            ans.add(new ArrayList<>(temp));
	            return;
	        } 
	        if(curr>target)return;  //if we have sum> target, then we need to backtrack. hence go back
	        
	        for(;i<candi.length;i++){
	        	 
	            temp.add(candi[i]); //add current element to temp list
	            curr= curr+candi[i]; //get current sum with new element
	            combi(ans,temp,candi,target,i, curr); //make recurive call to check if we have obtained the sum 
	            curr=curr-candi[i]; //subtract the current element from the sum and 
	            temp.remove(temp.size()-1); //remove that element from our temp list, i.e. we backtrack our answer here
	            //to add next element from the array on top and repeat computation to check if we have achieved target sum
	        }
	        return;
	    }
}
