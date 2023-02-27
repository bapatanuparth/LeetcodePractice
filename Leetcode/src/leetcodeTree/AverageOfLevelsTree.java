package leetcodeTree;
import java.util.*;

//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
//		Answers within 10-5 of the actual answer will be accepted.

//Input: root = [3,9,20,null,null,15,7]
//Output: [3.00000,14.50000,11.00000]
public class AverageOfLevelsTree {

	  public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> res= new ArrayList<>();
	        
	        if(root==null) return res;
	        Deque<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            int size = q.size();
	            
	            double sum=0;
	            
	            for(int i=0;i<size;i++){
	                TreeNode curr = q.pollFirst();
	                sum=sum+(double)curr.val;
	                if(curr.left!=null) q.add(curr.left);
	                if(curr.right!=null) q.add(curr.right);
	            }
	            sum/=size;
	            res.add(sum);
	        }
	        
	        return res;    
	    }
}
