package leetcodeBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
//
//Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
//
//This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
//
//Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
//
//It's guaranteed that each city can reach city 0 after reorder.
public class ReorderRoutesMakeAllPathsLeadToCityZero {

	int count = 0;

	public int minReorder(int n, int[][] connections) {

		List<List<Integer>> adj = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();

		// build an undirected graph and a directed graph
		// diorected graph will tell us if the edge was incoming or outgoing
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		boolean visited[] = new boolean[n];

		for (int[] conn : connections) {
			adj.get(conn[0]).add(conn[1]);
			adj.get(conn[1]).add(conn[0]);
			if (map.containsKey(conn[0])) {
				map.get(conn[0]).add(conn[1]);
			} else {
				Set<Integer> s = new HashSet<>();
				s.add(conn[1]);
				map.put(conn[0], s);
			}
		}
		// now we have whole city plan in adjacency list
		// perform basic BFS starting zero.
		// for all the routes coming to zero, dont increase the count,
		// if the route is going away from zero, increase the count
		// count represents the number of roads whose direction needs to be changed to
		// align it to zero

		int count = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			for (int next : adj.get(cur)) {
				if (visited[next] == true)
					continue;
				if (map.containsKey(cur) && map.get(cur).contains(next))
					count++;
				q.add(next);
			}
		}

		return count;

	}
}
