package leetCodeArrays;
import java.util.*;


public class MergeIntervals {

	//solution 1
	  public int[][] merge(int[][] arr) {
	        List<int[]> res= new ArrayList<>();
	        //ez sorting of 2D array on our condition
	        Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));
	        
	        int a=arr[0][0], b=arr[0][1];
	        
	        for(int i=1;i<arr.length;i++){
	            if(arr[i][0]>b){
	                res.add(new int []{a,b});
	                a=arr[i][0];b=arr[i][1];
	                continue;
	            }
	            if(arr[i][0]<=b){
	                b=Math.max(arr[i][1],b);
	            }
	        }
	        res.add(new int[]{a,b});
	        
	        return res.toArray(new int [res.size()][]);
	        
	    }
	  
	  //solution 2
	  public int[][] merge2(int[][] intervals) {
	        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	        LinkedList<int[]> merged = new LinkedList<>();
	        for (int[] interval : intervals) {
	            // if the list of merged intervals is empty or if the current
	            // interval does not overlap with the previous, simply append it.
	            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
	                merged.add(interval);
	            }
	            // otherwise, there is overlap, so we merge the current and previous
	            // intervals.
	            else {
	                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
	            }
	        }
	        return merged.toArray(new int[merged.size()][]);
	    }
}
