package leetcodeTree;
import java.util.*;

//print level order but bottom up i.e. leaf nodes in beginning to root at the end
public class LevelOrderBottomUp {

	//apply same logic of level order traversal
	//add each new list at the beginning of the result List<List<Int>>
	//this way every new level will be added at the beginning, printing the end first and root node at last
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> res = new LinkedList<>();
	        if(root==null) return res;
	        
	        Deque<TreeNode> q= new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int size= q.size();
	            List<Integer> temp= new ArrayList<>();
	            for(int i=0;i<size;i++){
	                TreeNode curr= q.pollFirst();
	                if(curr.left!=null) q.add(curr.left);
	                if(curr.right!=null) q.add(curr.right);
	                temp.add(curr.val);
	            }
	            res.add(0, temp);
	            
	        }
	        return res;
	        
	    }
}
