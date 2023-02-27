package leetcodeTree;
import java.util.*;

public class LevelOrderTraversal {

	 public List<List<Integer>> levelOrder(TreeNode root) {
		 //if u use arraydeque for queue implementation, it will give an error
		 //use linkedlist
	        Deque<TreeNode> ad= new LinkedList<>();
	        
	        List<List<Integer>> res= new ArrayList<>();
	        if(root==null) return res;
	        ad.add(root);
	        ad.add(null);
	        List<Integer> ls = new ArrayList<>();
	        
	       
	        while(ad.size()>1){
	            TreeNode curr= ad.poll();
	            if(curr==null){ 
	                res.add(ls);
	                ls= new ArrayList<>();
	                ad.add(null);
	                continue;
	            }
	            if(curr.left!=null) ad.add(curr.left);
	            if(curr.right!=null) ad.add(curr.right);
	            
	            ls.add(curr.val);
	            
	        }
	        res.add(ls);
	     return res;   
	        
	    }
}
