package leetcodeTree;

//Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
//
//Return the root of the Quad-Tree representing the grid.
//
//Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the answer.
//
//A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
//
//val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
//isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
//class Node {
//    public boolean val;
//    public boolean isLeaf;
//    public Node topLeft;
//    public Node topRight;
//    public Node bottomLeft;
//    public Node bottomRight;
//}
//We can construct a Quad-Tree from a two-dimensional area using the following steps:
//
//If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
//If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
//Recurse for each of the children with the proper sub-grid.

public class ConstructQuadTree {

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}

		// check if the entire selected square has same value or not
		boolean samevalue(int[][] grid, int x1, int y1, int length) {
			int val = grid[x1][y1];

			for (int i = x1; i < x1 + length; i++) {
				for (int j = y1; j < y1 + length; j++) {
					if (grid[i][j] != val)
						return false;
				}
			}

			return true;
		}

		Node solve(int[][] grid, int x1, int y1, int length) {
			// if square has same val, mark it as leaf and return
			if (samevalue(grid, x1, y1, length)) {
				boolean val = grid[x1][y1] == 1;
				return new Node(val, true);
			} else {
				// else, divide square in to 4 sub squares and assign to 4 quadrants.\
				// recursively check for sub squares
				Node n = new Node(false, false);

				n.topLeft = solve(grid, x1, y1, length / 2);
				n.topRight = solve(grid, x1, y1 + length / 2, length / 2);
				n.bottomLeft = solve(grid, x1 + length / 2, y1, length / 2);
				n.bottomRight = solve(grid, x1 + length / 2, y1 + length / 2, length / 2);

				return n;
			}
		}

		public Node construct(int[][] grid) {
			return solve(grid, 0, 0, grid.length);
		}
	}
}
