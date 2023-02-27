package leetcodeTree;

public class MaxDepthOfNAryTree {

	 public int maxDepth(Node root) {
	        if(root==null) return 0;
	        if(root.children.size()==0)return 1;
	        int h=0;
	        for(int i=0;i<root.children.size();i++){
	            h=Math.max(h, maxDepth(root.children.get(i)));
	        }
	        return h+1;
	    }
}
