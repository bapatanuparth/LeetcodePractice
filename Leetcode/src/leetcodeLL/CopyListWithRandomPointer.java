package leetcodeLL;

import java.util.HashMap;
import java.util.Map;

//A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
//
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//Return the head of the copied linked list.
//
//The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//val: an integer representing Node.val
//random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
//Your code will only be given the head of the original linked list.

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class CopyListWithRandomPointer {

	// create a map to store which old node points to which new node
	// then just take out the corresponding next and random out of map
	public Node copyRandomList(Node head) {
		if (head == null)
			return null;

		Node temp = head;
		Map<Node, Node> map = new HashMap<>();

		// create whole new deep copy and map of the old --> new nodes
		while (temp != null) {
			Node head2 = new Node(temp.val);
			map.put(temp, head2);
			temp = temp.next;
		}

		// get each node and its next and random pointer
		for (Node val : map.keySet()) {
			Node curr = map.get(val);
			Node next = map.get(val.next);
			Node rand = map.get(val.random);

			curr.next = next;
			curr.random = rand;
		}

		return map.get(head);
	}
}
