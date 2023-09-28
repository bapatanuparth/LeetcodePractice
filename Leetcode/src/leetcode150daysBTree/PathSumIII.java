package leetcode150daysBTree;

//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

public class PathSumIII {

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return pathsFromNode(root, (long) sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	int pathsFromNode(TreeNode root, long sum) {
		if (root == null)
			return 0;
		return (root.val == sum ? 1 : 0) + pathsFromNode(root.left, sum - root.val)
				+ pathsFromNode(root.right, sum - root.val);
	}

}
