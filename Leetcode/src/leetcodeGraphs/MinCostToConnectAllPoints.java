package leetcodeGraphs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
//
//The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
//
//Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

public class MinCostToConnectAllPoints {

	public int minCostConnectPoints(int[][] points) {
		boolean visited[] = new boolean[points.length];
		int[] dist = new int[points.length];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		q.add(new int[] { 0, 0 });

		int total = 0;
		while (!q.isEmpty()) {

			int ind[] = q.poll();
			if (visited[ind[0]])
				continue;

			total += ind[1];
			visited[ind[0]] = true;

			for (int i = 0; i < points.length; i++) {
				if (i == ind[0] || visited[i])
					continue;
				int distance = getDist(points, ind[0], i);
				if (dist[i] > distance)
					dist[i] = distance;
				q.add(new int[] { i, distance });
			}
		}

		return total;
	}

	int getDist(int[][] points, int i, int j) {
		int[] p1 = points[i];
		int[] p2 = points[j];

		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

}
