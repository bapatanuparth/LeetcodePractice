package leetcodeheap;
import java.util.*;

public class KClosestPointsToOrigin {

	 public int[][] kClosest(int[][] points, int k) {
	       Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
	        
	       //create a minheap of int[] -->[squared_distance, index of the point]
	        for(int i=0;i<points.length;i++){
	            int [] entry = {squareDistance(points[i]),i};
	            minHeap.add(entry); //sort entry based on the squared distance of point at ith index
	        }
	        
	        int [][] res= new int[k][];
	     for(int i=0;i<k;i++){
	         int [] temp= points[minHeap.poll()[1]]; //fetch k smallest points based on their minimum distance from origin.
	         res[i]=temp; //these points are fetched based on their index in the [1] position 
	     }
	       
	        return res;
	    }
	    
	    private int squareDistance(int [] point){
	        return point[0]*point[0] + point[1]*point[1];
	    }
}
