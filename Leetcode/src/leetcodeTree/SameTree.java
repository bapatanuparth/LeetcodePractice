package leetcodeTree;

//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
public class SameTree {

	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        
	        if(p!=null && q!=null){
	            if(p.val!=q.val)return false;
	            boolean left = isSameTree(p.left, q.left);
	            return left && isSameTree(p.right,q.right);                
	        }
	        else if(p==null && q==null)
	            return true;
	        else
	            return false;   
	        
	    }
}
