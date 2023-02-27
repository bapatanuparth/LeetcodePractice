package leetcodeTree;
import java.util.*;

public class PreOrderTraversal {

	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        return preTraversal(root, res);
	    }
	    
	    public List<Integer> preTraversal(TreeNode root, List<Integer> ls){
	        if(root== null) return ls;
	        
	        ls.add(root.val);
	        preTraversal(root.left, ls);
	        preTraversal(root.right, ls);
	        
	        return ls;
	        
	    }
}
