package leetcode150daysBFS;

import java.util.ArrayDeque;
import java.util.Queue;

//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
//The distance between two adjacent cells is 1

public class ZeroOneMatrix {

	int[] DIR = new int[] { 0, 1, 0, -1, 0 };

	public int[][] updateMatrix(int[][] mat) {
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					q.offer(new int[] { i, j });
				} else {
					mat[i][j] = -1;
				}
			}
		}

		while (!q.isEmpty()) {
			int curr[] = q.poll();
			int r = curr[0], c = curr[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + DIR[i];
				int nc = c + DIR[i + 1];
				if (nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length || mat[nr][nc] != -1)
					continue;
				mat[nr][nc] = mat[r][c] + 1;
				q.offer(new int[] { nr, nc });
			}
		}

		return mat;
	}

}
