package leetCodeArrays2;
import java.util.*;


public class TargetIndices {

	//O(n) fastest solution
	 public List<Integer> targetIndicesEff(int[] nums, int target) {
	        int count=0;
	        int greater=0;
	        int lesser=0;
	        
	        List<Integer> res= new ArrayList<>();
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==target)
	                count++;
	            else if(nums[i]>target)
	                greater++;
	            else if(nums[i]<target)
	                lesser++;
	        }
	        
	        for(int i=lesser;i<(lesser+count);i++){
	            res.add(i);
	        }
	        
	       return res;
	        
	    }
	
	
	
	
	//O(n logn) trivial solution
	  public List<Integer> targetIndices(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<Integer> res= new ArrayList<>();
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==target)
	                res.add(i);
	        }
	        
	       return res;
	        
	    }
}
