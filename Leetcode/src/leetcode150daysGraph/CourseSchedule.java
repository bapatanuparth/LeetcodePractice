package leetcode150daysGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] indegree = new int[numCourses];
		int[] outdegree = new int[numCourses];

		// create adjacency list from the given courses
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {

			adj.add(new ArrayList<>());
		}
		for (int[] arr : prerequisites) {
			int u = arr[1];
			int v = arr[0];
			adj.get(u).add(v);
			indegree[v]++;
			outdegree[u]++;
		}
		// check if there is a cycle in the directed graph
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}
		int count = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			count++;
			for (int neighbor : adj.get(u)) {
				indegree[neighbor]--;
				if (indegree[neighbor] == 0)
					q.offer(neighbor);
			}
		}

		return count == numCourses;

	}

}
