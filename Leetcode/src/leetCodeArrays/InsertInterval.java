package leetCodeArrays;
import java.util.*;

public class InsertInterval {

	 public int[][] insert(int[][] intervals, int[] newInterval) {
	        LinkedList<int[]> res = new LinkedList();
	        LinkedList<int[]> list = new LinkedList();
	        
			//Convert to list
	        for(int[] arr : intervals){
	            res.add(arr);    
	        }
	        // Add newInterval
	        res.add(newInterval);
	        //Sort them based on 0th index 
	        Collections.sort(res, new Comparator<int[]>(){
	            public int compare(int[] a , int[] b){
	                return a[0]-b[0];
	            }
	        });
	        
			//Simply Apply Merge Interval problem logic
	        for(int[] item: res){
	            if(list.isEmpty() || item[0]>list.getLast()[1]){
	                list.add(item);
	            }else{
	                list.getLast()[1]= Math.max(list.getLast()[1], item[1]);
	            }
	        }
	        return list.toArray(new int[list.size()][]);
	    }
	
}
