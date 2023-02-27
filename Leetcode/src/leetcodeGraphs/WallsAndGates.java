package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//You are given an m x n grid rooms initialized with these three possible values.
//
//-1 A wall or an obstacle.
//0 A gate.
//INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
public class WallsAndGates {

	// OPTIMIZED BY PUTTING ALL GATES IN THE
	// QUEUE AT ONCE AND THEN DOING BFS
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	private static final List<int[]> DIRECTIONS = Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 },
			new int[] { 0, 1 }, new int[] { 0, -1 });

	public void wallsAndGatesEff(int[][] rooms) {
		int m = rooms.length;
		if (m == 0)
			return;
		int n = rooms[0].length;

		// add all gates at a time in the queue to avoid enqueing for each gate again
		// and then running the loop over the whole rooms grid
		Queue<int[]> q = new LinkedList<>();
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (rooms[row][col] == GATE) {
					q.add(new int[] { row, col });
				}
			}
		}
		// this way as all gates are in bfs queue at a time, any adjacent element we
		// choose is going to have the smallest distance from gate by default
		while (!q.isEmpty()) {
			int[] point = q.poll();
			int row = point[0];
			int col = point[1];
			for (int[] direction : DIRECTIONS) {
				int r = row + direction[0];
				int c = col + direction[1];

				if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
					continue;
				}
				// will reach here only if the room is empty i.e. has infinite value so no
				// problem of infinite loop or filling up wrong value
				rooms[r][c] = rooms[row][col] + 1;
				q.add(new int[] { r, c });
			}
		}
	}

	// scan the rooms and call bfs from the gates
	// go at each gate, BFS and update the count after each level of traversal
	// repeat for every gate
	public void wallsAndGates(int[][] rooms) {

		for (int i = 0; i < rooms.length; i++) {

			for (int j = 0; j < rooms[0].length; j++) {

				if (rooms[i][j] == 0)
					bfs(rooms, i, j);
			}
		}
	}

	// direction to perform bfs in
	// 4 adjacent sides
	int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	void bfs(int[][] rooms, int i, int j) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { i, j });
		int count = 0;
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];

		// perform bfs and assign min value at each rooms[i][j]
		// do this only starting at the gates
		while (!q.isEmpty()) {

			int size = q.size();
			count++;

			for (int m = 0; m < size; m++) {

				int[] room = q.poll();

				for (int[] arr : dirs) {

					int x = room[0] + arr[0];
					int y = room[1] + arr[1];

					if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] == -1
							|| rooms[x][y] == 0 || visited[x][y])
						continue;

					visited[x][y] = true;
					rooms[x][y] = Math.min(rooms[x][y], count);
					q.add(new int[] { x, y });

				}

			}
		}

	}
}
