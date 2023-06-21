package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
//
//Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
//
//The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
//
//The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
//
//Return the number of minutes needed to inform all the employees about the urgent news.

public class TimeNeededToInformAllEmployees {

	class Solution {

		class Node {
			int index;
			int infoTime;
			int manager;
			List<Node> children;

			public Node() {
				children = new ArrayList<>();
			}

			public Node(int i, int info, int man) {
				children = new ArrayList<>();
				index = i;
				infoTime = info;
				manager = man;
			}

		}

		public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
			Node[] arr = new Node[n];

			for (int i = 0; i < n; i++) {
				arr[i] = new Node(i, informTime[i], manager[i]);
			}

			for (int i = 0; i < n; i++) {
				if (manager[i] == -1)
					continue;
				arr[manager[i]].children.add(arr[i]);
			}

			return dfs(arr[headID]);
		}

		int dfs(Node head) {
			if (head.children.size() == 0)
				return 0;
			int ans = 0;
			for (int i = 0; i < head.children.size(); i++) {
				ans = Math.max(ans, dfs(head.children.get(i)));
			}

			return ans + head.infoTime;
		}
	}

}
