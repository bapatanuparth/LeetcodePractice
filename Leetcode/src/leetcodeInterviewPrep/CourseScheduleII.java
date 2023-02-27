package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

	// use topological sort with cycle detection
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		// create adjacency list
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] arr : prerequisites) {
			adj.get(arr[1]).add(arr[0]);
		}

		// create pre requisites for cycle detetction and topological sort
		// stack is used to store elements that appear in reverse order in the
		// topological sort
		// example == 1->2->3->4 , here 4 will be pushed first as we do DFS, reach the
		// end of DFS and then add element to stack
		// so we will get the topological sorted values in stack
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[numCourses];
		boolean recstack[] = new boolean[numCourses];

		// run the code for cycle detection
		for (int i = 0; i < adj.size(); i++) {
			if (visited[i] == false) {
				if (isCycle(visited, recstack, adj, i, st))
					return new int[] {}; // if cycle present return empty array
			}
		}

		// else convert stack to int []
		Collections.reverse(st);
		List<Integer> ls = new ArrayList<>(st);
		int[] example1 = ls.stream().mapToInt(i -> i).toArray();
		return example1;
	}

	// simple directed graph cycle detection
	boolean isCycle(boolean[] visited, boolean[] recstack, List<List<Integer>> adj, int v, Stack<Integer> st) {

		visited[v] = true;
		recstack[v] = true;
		for (int i : adj.get(v)) {

			if (visited[i] == false) {
				if (isCycle(visited, recstack, adj, i, st))
					return true;
			} else if (recstack[i])
				return true;

		}

		recstack[v] = false;
		// here we add element to stack only after all its descendents are added, giving
		// topological sorting
		st.add(v);
		return false;
	}
}
