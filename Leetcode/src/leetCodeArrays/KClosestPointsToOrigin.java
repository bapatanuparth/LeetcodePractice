package leetCodeArrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//read solutions on leetcode -- very good intuitive solutions
public class KClosestPointsToOrigin {
	
	//better solution using priority queue
	  public int[][] kClosestEff(int[][] points, int k) {
	       Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
	        
	        for(int i=0;i<points.length;i++){
	            int [] entry = {squareDistance(points[i]),i};
	            minHeap.add(entry);
	        }
	        
	        int [][] res= new int[k][];
	     for(int i=0;i<k;i++){
	         int [] temp= points[minHeap.poll()[1]];
	         res[i]=temp;
	     }
	       
	        return res;
	    }
	
	
	//naive solution, use custom comparator lambda function -> sort the array -> return first k elements of sorted	
	public int[][] kClosest(int[][] points, int k) {
	       Arrays.sort(points, (a,b)->squareDistance(a)-squareDistance(b));
	    
	        return Arrays.copyOf(points, k);
	       
	    }
	    
	    private int squareDistance(int [] point){
	        return point[0]*point[0] + point[1]*point[1];
	    }
}
