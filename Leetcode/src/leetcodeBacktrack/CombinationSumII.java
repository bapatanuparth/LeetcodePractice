package leetcodeBacktrack;
import java.util.*;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.

//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
public class CombinationSumII {

	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        Arrays.sort(candidates); //sort elements so we can identify and avoid duplicates by checking previous numbers
	        List<Integer> temp= new ArrayList<>();
	        List<List<Integer>> out =  new ArrayList<>();
	        combi(out, temp, 0, target, candidates);
	        return out;
	        }
	    

	    void combi(List<List<Integer>> out, List<Integer> temp, int i, int target, int[] candidates){
	        if(target == 0){
	       
	                out.add(new ArrayList<>(temp));
	            return;
	        }
	        if(target <0)return;
	            
	            for(int next=i;next<candidates.length;next++){
	                if(next>i && candidates[next]== candidates[next-1]) //avoid making duplicates, skip if element == element-1
	                    continue; //, it makes sure that only one instance of the duplicated inputs is picked in the "for loop" at a given recursion level.
	                temp.add(candidates[next]);
	                int rem= target - candidates[next];
	                combi(out, temp, next+1, rem, candidates);
	                temp.remove(temp.size()-1);
	            }
	    }
}
