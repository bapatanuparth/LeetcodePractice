package leetcodeBacktrack;

//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//Output: true
public class WordSearch {

	 public boolean exist(char[][] board, String word) {
	        boolean [][] visited = new boolean[board.length][board[0].length];
	        return existDP(board, word,visited);
	    }
	    
	    boolean existDP(char[][] board, String word, boolean [][] visited){
	      
	        for(int i=0;i<board.length;i++){
	            
	            for(int j=0;j<board[0].length;j++){
	                
	                System.out.println(board[i][j]);
	                    if(check(board, word, i,j,visited))return true;
	            }
	            
	        }
	        
	        return false;  
	    }
	    
	    boolean check(char[][] board, String word, int i, int j, boolean [][] visited){
	         if(word.equals(""))
	            return true;
	        
	        if(i<0 || j<0 || i==board.length || j==board[0].length) return false;
	        if(visited[i][j]==true) return false;
	        
	        
	         if(word.indexOf(board[i][j])==0){
	                visited[i][j]=true;
	                if(check(board, word.substring(1,word.length()),i, j+1, visited))return true;
	                if(check(board, word.substring(1,word.length()),i+1, j, visited))return true;
	                if(check(board, word.substring(1,word.length()),i-1, j, visited))return true;
	                if(check(board, word.substring(1,word.length()),i, j-1, visited))return true;
	                visited[i][j]=false;
	         }
	        return false;
	    }
}
