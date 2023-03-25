package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

public class CourseScheduleII {

	// topological sort algorithm
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		List<List<Integer>> adj = new ArrayList<>();
		int[] indegree = new int[numCourses];
		int[] topo = new int[numCourses];

		// create adjacency list
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] arr : prerequisites) {
			int src = arr[1];
			int dest = arr[0];
			adj.get(src).add(dest);

			// keep track of indegree of each element
			indegree[dest] += 1;
		}

		// add all those whose indegree == 0
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		int i = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			topo[i++] = node;
			// for each neighbor, after considering his parent, reduce its in-degree
			// if indegree==0, it means we can move to this element in topological sort
			// add this element to queue
			for (int neigh : adj.get(node)) {
				indegree[neigh]--;

				if (indegree[neigh] == 0)
					q.add(neigh);
			}
		}

		// if a cycle occurrs, there will come a case where no element has indegree ==0
		// but there are still elements yet to be visited
		// in this case, i will not have processed all the n elements
		// this will tell us if there was a cycle in the graph or not
		if (i == numCourses)
			return topo;
		else
			return new int[] {};
	}

}
