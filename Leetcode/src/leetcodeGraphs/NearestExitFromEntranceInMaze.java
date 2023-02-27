package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.Queue;
//You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
//
//In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
//
//Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
//
// 

public class NearestExitFromEntranceInMaze {

	public int nearestExit(char[][] maze, int[] entrance) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(entrance);

		boolean visited[][] = new boolean[maze.length][maze[0].length];
		visited[entrance[0]][entrance[1]] = true; // visited array marked during pushing in queue and not after popping

		int dir[][] = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {

				int[] loc = q.poll();

				if (checkBorder(maze, loc) && loc != entrance) {
					return step;
				}

				for (int j = 0; j < 4; j++) {
					int x = loc[0] + dir[j][0];
					int y = loc[1] + dir[j][1];

					if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == '+' || visited[x][y])
						continue;

					q.add(new int[] { x, y });
					visited[x][y] = true; // mark visited while pushing and not after popping
					// because, if we mark it after popping, while pushing in queue, we can push
					// even duplicates as in BFS, 1 cell can have 2 common neighbors which get
					// processed before that cell. so both neighbors add the same cell
				}
			}
			step++;

		}

		return -1;

	}

	boolean checkBorder(char[][] maze, int[] location) {
		if (location[0] == 0 || location[0] == maze.length - 1 || location[1] == 0 || location[1] == maze[0].length - 1)
			return true;
		return false;
	}
}
