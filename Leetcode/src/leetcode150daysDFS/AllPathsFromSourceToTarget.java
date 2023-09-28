package leetcode150daysDFS;

import java.util.ArrayList;
import java.util.List;

//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
//
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

public class AllPathsFromSourceToTarget {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		ls.add(0);
		boolean visited[] = new boolean[graph.length];
		dfs(res, ls, 0, visited, graph);

		return res;
	}

	void dfs(List<List<Integer>> res, List<Integer> temp, int src, boolean[] visited, int[][] graph) {

		if (src == graph.length - 1) {
			res.add(new ArrayList<>(temp));
			return;
		}

		visited[src] = true;

		for (int j = 0; j < graph[src].length; j++) {
			if (visited[graph[src][j]] == false) {
				temp.add(graph[src][j]);
				dfs(res, temp, graph[src][j], visited, graph);
				temp.remove(temp.size() - 1);
			}
		}

		visited[src] = false;
	}

}
