package leetcodeGraphs;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


//Input: grid = [
//               ["1","1","0","0","0"],
//               ["1","1","0","0","0"],
//               ["0","0","1","0","0"],
//               ["0","0","0","1","1"]
//             ]
//             Output: 3
public class NumberOfIslands {

	//DFS approach
	 public int numIslands(char[][] grid) {
	        
	        boolean visited[][] = new boolean[grid.length][grid[0].length]; //to keep a track of visited nodes
	        int islands=0;
	    
	        for(int i=0;i<grid.length;i++){
	            
	            for(int j=0;j<grid[0].length;j++){
	                
	                if(visited[i][j]==false && grid[i][j]=='1'){
	                    islands++;
	                    gridbfs(grid, visited, i, j); //if found 1, check for all of its adjacents if they are 1, mark them as visited
	                }
	            }
	        }
	        return islands;
	        
	    }
	    
	    void gridbfs(char[][] grid, boolean[][] visited, int i, int j){
	        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0' ||visited[i][j]==true)
	            return;
	     
	        visited[i][j]=true; 
	        //check for all adjacents 1 by 1 and mark them as visited. these all will be a part of 1 parent island only
	        gridbfs(grid, visited, i+1, j);
	        gridbfs(grid, visited, i, j+1);
	        gridbfs(grid, visited, i-1, j);
	        gridbfs(grid, visited, i, j-1);
	    }
}
