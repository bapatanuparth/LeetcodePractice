package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {

	//DFS solution
	//recursive
	  public TreeNode invertTreeDFS(TreeNode root) {
	        if(root==null) return root;
	        TreeNode temp=invertTree(root.left);
	        root.left=invertTree(root.right);
	        root.right=temp;
	        return root;
	    }
	
	
	//BFS solution
	 public TreeNode invertTree(TreeNode root) {
	        if(root==null) return null;
	        Queue<TreeNode> q= new ArrayDeque<>(); //create queue for BFS
	        q.add(root); //add root
	        
	        while(!q.isEmpty()){
	            TreeNode temp=q.poll();
	            TreeNode left= temp.left; //set up pointers for left and right of polled element
	            TreeNode right=temp.right;
	            
	            temp.left=right; //exchange the references to left and right
	            temp.right=left;
	            
	            //now root.left points to previous right and root.right points to previous left
	            if(temp.left!=null)q.add(temp.left); 
	            if(temp.right!=null)q.add(temp.right);
	        }
	        
	        return root;
	    }
}
