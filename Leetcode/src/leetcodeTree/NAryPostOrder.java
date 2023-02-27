package leetcodeTree;
import java.util.*;

public class NAryPostOrder {

	 public List<Integer> postorder(Node root) {
	        List<Integer> op = new ArrayList<>();
	        narypost(root, op);
	        return op;
	    }
	    
	    public void narypost(Node root, List<Integer> op){
	        if(root==null)return;
	        if(root.children.size()==0){
	            op.add(root.val);
	            return;
	        }
	        //System.out.println(root.children.size());
	        for(int i=0;i<root.children.size();i++){
	            narypost(root.children.get(i),op);
	        }
	        op.add(root.val);
	    }
}
