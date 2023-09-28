package leetcode150daysBTree;

//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

//
//Initially, all next pointers are set to NULL.

public class PopulatingNextRightPointer {

	public Node connect(Node root) {
		if (root == null)
			return root;
		Node leftmost = root;
		while (leftmost.left != null) {

			Node head = leftmost;
			while (head != null) {

				// connection 1
				head.left.next = head.right;

				// connection 2
				if (head.next != null) {
					head.right.next = head.next.left;
				}

				head = head.next;
			}

			leftmost = leftmost.left;
		}

		return root;
	}

}
