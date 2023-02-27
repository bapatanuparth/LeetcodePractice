package leetcodeBacktrack;
import java.util.*;


public class SubsetsII {

	
	//efficient code
	//sort arrays and every time check if the current num == previous num. 
	//if current num== previous num, do not include it in the next iteration hence u will avoid the duplicates
	//otherwise code is same as subsets problem
	 public List<List<Integer>> subsetsWithDupEff(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> tmp = new ArrayList<>();
	        dfs(nums, 0, nums.length - 1, ans, tmp);
	        return ans;
	    }
	    
	    public void dfs(int[] nums, int start, int end, List<List<Integer>> ans, List<Integer> tmp){
	        ans.add(new ArrayList<>(tmp));
	        
	        for(int i = start; i <= end; i++){
	            if(i != start && nums[i] == nums[i - 1]) continue; //check whether current number == prev number
	            tmp.add(nums[i]);
	            dfs(nums, i + 1, end, ans, tmp);
	            tmp.remove(tmp.size() - 1);
	        }
	        
	    }
	
	
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
	        List<Integer> temp = new ArrayList<>();
	        List<List<Integer>> out = new ArrayList<>();
	        Set<List<Integer>> set= new HashSet<>();
	        Arrays.sort(nums);
	        
	        substrings(nums, temp, out, set, 0);
	        return out;
	    }
	    
	 //check if list has been seen previously
	    boolean listPresent(Set<List<Integer>> set, List<Integer> temp){
	        for(List<Integer> ls: set){
	            if(ls.equals(temp))return true;
	        }
	        return false;
	    }
	    
	    
	    void substrings(int [] nums, List<Integer> temp, List<List<Integer>> out, Set<List<Integer>> set, int i){
	        if(!listPresent(set, temp))
	        {
	            out.add(new ArrayList<>(temp));
	            set.add(new ArrayList<>(temp));
	        }
	        
	        for(;i<nums.length;i++){
	            temp.add(nums[i]);
	            substrings(nums, temp, out, set, i+1);
	            temp.remove(temp.size()-1);
	        }
	    }
}
