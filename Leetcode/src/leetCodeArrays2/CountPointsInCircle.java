package leetCodeArrays2;
//You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
//
//You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
//
//For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
//
//Return an array answer, where answer[j] is the answer to the jth query


//Queries on Number of Points Inside a Circle Leetcode-- 1828

//Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//Output: [3,2,2]
public class CountPointsInCircle {

	//if euclidean distance between a point and circle < radius, the point is inside the circle
	 public int[] countPoints(int[][] points, int[][] queries) {
	        
	        int [] res= new int[queries.length];
	        for(int i=0;i<queries.length;i++){
	            
	            int [] circle= queries[i];
	            int rad= circle[2];
	            
	            for(int [] point: points){
	                int x= point[0]-circle[0];
	                int y= point[1]-circle[1];
	                if(rad>=Math.sqrt(x*x + y*y)){
	                 res[i]++;   
	                }
	                
	            }
	                
	        }
	        
	        return res;
	    }
}
