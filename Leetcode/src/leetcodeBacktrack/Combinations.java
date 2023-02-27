package leetcodeBacktrack;
import java.util.*;

public class Combinations {

	 public List<List<Integer>> combine(int n, int k) {
	        List<Integer> out= new ArrayList<>();
	        List<List<Integer>> res = new ArrayList<>();
	        
	        makeCombine(res, out, n, k, 0);
	        return res;
	    }
	    
	    void makeCombine(List<List<Integer>> res, List<Integer> out, int n, int k, int i){
	        
	        if(out.size()==k){
	            res.add(new ArrayList<>(out));
	        }
	        
	        for(;i<n;i++){
	            out.add(i+1);
	            makeCombine(res, out, n, k, i+1);
	            out.remove(out.size()-1);
	        }
	        
	    }
}
