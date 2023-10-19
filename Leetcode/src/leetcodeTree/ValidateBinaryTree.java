package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ValidateBinaryTree {

	class Solution {
		public boolean validateBinaryTreeNodes(int n, int[] leftchild, int[] rightchild) {
			int[] in = new int[n];

			for (int i = 0; i < n; i++) {
				if (leftchild[i] != -1)
					in[leftchild[i]]++;
				if (rightchild[i] != -1)
					in[rightchild[i]]++;
			}

			Queue<Integer> q = new ArrayDeque<>();

			// only 1 root should be there and no element has more than 1 incoming nodes
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (in[i] == 0 && flag || in[i] > 1)
					return false;
				if (in[i] == 0) {
					q.add(i);
					flag = true;
				}
			}

			int vis = 0;
			// there should be no cycles
			while (!q.isEmpty()) {
				int curr = q.poll();
				vis++;
				if (leftchild[curr] != -1) {
					in[leftchild[curr]]--;
					if (in[leftchild[curr]] == 0)
						q.add(leftchild[curr]);
				}
				if (rightchild[curr] != -1) {
					in[rightchild[curr]]--;
					if (in[rightchild[curr]] == 0)
						q.add(rightchild[curr]);
				}
			}

			return vis == n;
		}
	}

}
