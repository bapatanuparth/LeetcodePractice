package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship). Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.
//
//You must find the minimum number of months needed to complete all the courses following these rules:
//
//You may start taking a course at any time if the prerequisites are met.
//Any number of courses can be taken at the same time.
//Return the minimum number of months needed to complete all the courses.
//
//Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).

public class ParallelCoursesIII {

	// create a node for course
	// store the coursenumber and max time required to finish that course
	class Node {
		int val;
		int maxtime;

		public Node(int v, int t) {
			this.val = v;
			this.maxtime = t;
		}

		public String toString() {
			return val + " " + maxtime;
		}

	}

	public int minimumTime(int n, int[][] relations, int[] time) {

		Node[] nodes = new Node[n + 1];
		int[] indegree = new int[n + 1];

		// create an adjacency list
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		// calculate indegree of each node with the graph
		for (int[] edge : relations) {
			indegree[edge[1]]++;
			adj.get(edge[0]).add(edge[1]);
		}

		Queue<Node> q = new ArrayDeque<>();
		// get all the courses with 0 indegree in a queue to perform topological sort
		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				nodes[i] = new Node(i, time[i - 1]);
				q.add(new Node(i, time[i - 1]));
			}
		}

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int value = curr.val;
			int currtime = curr.maxtime;
			// for each next course, calculate the maximum time that it will take to
			// complete all the courses up to that course.
			for (int neigh : adj.get(value)) {
				indegree[neigh]--;
				if (nodes[neigh] == null) {
					nodes[neigh] = new Node(neigh, currtime + time[neigh - 1]);
				} else {
					// for the neighbor, maintain the max time it takes to complete this course with
					// all prerequisites.
					nodes[neigh].maxtime = Math.max(nodes[neigh].maxtime, currtime + time[neigh - 1]);
				}
				// indegree zero means all pre-requisites are considered already
				if (indegree[neigh] == 0) {
					q.add(nodes[neigh]);
				}
			}

		}

		int ans = 0;
		// our answer will be the maximum time required for any course
		// this is right answer because each node holds the minimum time that is
		// required for that course completion
		for (int i = 1; i < nodes.length; i++) {
			ans = Math.max(ans, nodes[i].maxtime);
		}

		return ans;

	}

}
