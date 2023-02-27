package leetCodeArrays;

//You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y). You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi). A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.
//
//Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location. If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.
//
//The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).

//Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
//Output: 2
public class NearestValidPoint {

	  public int nearestValidPoint(int x, int y, int[][] points) {
		     
	        int dist=Integer.MAX_VALUE;
	        int minIndex=-1;
	        for(int i=0;i<points.length;i++){
	        
	            int [] arr=points[i];
	            
	            if(arr[0]==x || arr[1]==y){
	                int temp=Math.abs(arr[0]-x) + Math.abs(arr[1]-y);
	                if(temp<dist){
	                    dist=temp;
	                    minIndex=i;
	                }
	            }
	        }
	        
	        return minIndex;
	    }
}
