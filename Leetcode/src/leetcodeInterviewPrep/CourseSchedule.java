package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.List;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

public class CourseSchedule {

	// easy, create a directed graph based on the dependencies given in the question
	// then check if there is a cycle in the directed graph
	// if cycle present, it means we are in a deadlock and we cant create a schedule
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		// create adjacency list from the given courses
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {

			adj.add(new ArrayList<>());
		}
		for (int[] arr : prerequisites) {
			int u = arr[1];
			int v = arr[0];
			adj.get(u).add(v);
		}
		// check if there is a cycle in the directed graph
		boolean[] visited = new boolean[numCourses];
		boolean[] recstack = new boolean[numCourses];

		for (int i = 0; i < adj.size(); i++) {

			if (visited[i] == false) {
				if (isCycle(visited, recstack, adj, i))
					return false;
			}
		}

		return true;

	}

	boolean isCycle(boolean[] visited, boolean[] recstack, List<List<Integer>> adj, int v) {

		visited[v] = true;
		recstack[v] = true;
		for (int i : adj.get(v)) {

			if (visited[i] == false) {
				if (isCycle(visited, recstack, adj, i))
					return true;
			} else if (recstack[i])
				return true;

		}

		recstack[v] = false;
		return false;

	}
}
