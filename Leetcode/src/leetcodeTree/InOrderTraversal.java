package leetcodeTree;
import java.util.*;

public class InOrderTraversal {

	  public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> list= new ArrayList<>();
	        return inOrder(root, list);
	    }
	    
	    List<Integer> inOrder(TreeNode root, List<Integer> ls){
	    	  if(root==null)
		            return ls;
		        inOrder(root.left,ls);
		        ls.add(root.val);
		        inOrder(root.right,ls);
		        return ls;
	    }
}
