package leetcodeBFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
//
//The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
//
//You may assume that the borders of the maze are all walls (see examples).

public class TherMazeII {

	// basic dfs
	// we need to keep ball rolling in one direction till we hit the wall or end of
	// maze
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {

		int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		int[][] distance = new int[maze.length][maze[0].length];

		for (int[] arr : distance) {
			Arrays.fill(arr, -1);
		}

		distance[start[0]][start[1]] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(start);

		while (!q.isEmpty()) {

			int[] c = q.poll();

			for (int dir[] : dirs) {
				int count = distance[c[0]][c[1]];
				int x = c[0];
				int y = c[1];
				// this loop keeps the ball rolling till we encounter a wall or end of maze
				while (x + dir[0] >= 0 && x + dir[0] < maze.length && y + dir[1] >= 0 && y + dir[1] < maze[0].length
						&& maze[x + dir[0]][y + dir[1]] != 1) {
					x += dir[0];
					y += dir[1];
					count++;
				}
				// we mark only those co-ords where the ball stops after the loop
				// it is possible to visit same place again but we make sure that the count <
				// previous distance required to reach there
				if (distance[x][y] == -1 || count < distance[x][y]) {
					q.add(new int[] { x, y });
					distance[x][y] = count;
				}

			}
		}

		return distance[destination[0]][destination[1]];
	}

}
