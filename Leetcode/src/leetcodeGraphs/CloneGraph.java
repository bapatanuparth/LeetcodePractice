package leetcodeGraphs;

import java.util.ArrayList;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {

	  public Node cloneGraph(Node node) {
	        if(node == null)return null;
	        
	        Map<Node, Node> map= new HashMap<>(); //map store old node to new node
	        map.put(node, new Node(node.val));
	        Queue<Node> q= new ArrayDeque<>(); //to do BFS
	        q.add(node);
	        
	        while(!q.isEmpty()){
	            Node curr = q.poll(); //take the old node
	            
	            for(Node n:curr.neighbors){ //for each neighbor, if its not seen previously, create new and map it to the old
	                if(!map.containsKey(n)){ 
	                    map.put(n, new Node(n.val));
	                    q.add(n); //add to queue
	                }
	                map.get(curr).neighbors.add(map.get(n)); //for each neighbor, add it in the neighbors list of the mapped new node even if its seen before or not
	            }
	            
	        }
	        
	        return map.get(node);
	    }
}
