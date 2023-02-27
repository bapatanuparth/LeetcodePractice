package leetcodeTree;

public class MinimumDepthOfBtree {

	//to check if passed value is empty
	 boolean temp=false;
	    
	    public int minDepth(TreeNode root) {
	        if(root==null){
	        	//if tree is empty, return 0 else return integer. max_value
	            if(!temp) return 0;
	            return Integer.MAX_VALUE;
	        }
	        temp=true;    
	        
	        if(root.left==null && root.right==null){
	            return 1;
	        }
	        else
	            return Math.min(minDepth(root.left), minDepth(root.right))+1;
	    }
}
