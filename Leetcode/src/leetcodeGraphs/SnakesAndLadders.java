package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

import javafx.util.Pair;

public class SnakesAndLadders {

	public int snakesAndLadders(int[][] board) {
		int n = board.length;

		Integer[] columns = new Integer[n];
		for (int i = 0; i < n; i++) {
			columns[i] = i;
		}

		Pair<Integer, Integer> cells[] = new Pair[n * n + 1]; // this array maps board value to its approapriate row and
																// col co ordinate
		int label = 1;

		for (int row = n - 1; row >= 0; row--) {
			for (int col : columns) {
				cells[label++] = new Pair<>(row, col);
			}
			Collections.reverse(Arrays.asList(columns)); // we want to alternatively switch columns from 0 to n and n to
															// 0 for the next position to visit
		}

		int dist[] = new int[n * n + 1]; // stores distance to reach each position
		Arrays.fill(dist, -1);
		dist[1] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next = cur + 1; next <= Math.min(cur + 6, n * n); next++) {
				// get the row and col of next cell
				int row = cells[next].getKey(), col = cells[next].getValue();
				// get value where we go to from this next cell, i.e. destination
				int destination = board[row][col] == -1 ? next : board[row][col];
				// if the position not visited yet, mark visited and add to queue
				if (dist[destination] == -1) {
					dist[destination] = dist[cur] + 1;
					q.add(destination);
				}
			}
		}

		return dist[n * n];

	}

}
