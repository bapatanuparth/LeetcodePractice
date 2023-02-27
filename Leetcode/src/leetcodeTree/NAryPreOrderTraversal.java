package leetcodeTree;
import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


//Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]

//null in the input marks end of a list of children for each parent in the previous level
public class NAryPreOrderTraversal {

	//iterative solution
	public List preorderIter(Node root) {
		
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if (root== null)
			{ return output; }
		stack.add(root);
		while(!stack.isEmpty()){
			Node node=(Node) stack.pollLast();
			output.add(node.val);
			Collections.reverse(node.children);// to input nodes in reverse of postorder in stack
			for(Node child: node.children){
					stack.add(child);
				}
			} 
		return output;
		}
	
	
	//recursive solution
	 public List<Integer> preorder(Node root) {
	        List<Integer> op = new ArrayList<>();
	        pre(root,op);
	        return op;
	    }
	    
	    void pre(Node root, List<Integer> op){
	        if(root==null)return;
	        op.add(root.val);
	        for(int i=0;i<root.children.size();i++){
	            pre(root.children.get(i),op);
	        }
	      
	    }
}
