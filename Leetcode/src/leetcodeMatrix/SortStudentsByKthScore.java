package leetcodeMatrix;

//There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score contains distinct integers only.
//
//You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest.
//
//Return the matrix after sorting it.

public class SortStudentsByKthScore {

	class Solution {
		// traverse through all values at kth call, get highest, and swap with 1st row
		// repeat till end
		public int[][] sortTheStudents(int[][] score, int k) {

			for (int i = 0; i < score.length; i++) {
				int highest = 0;
				int maxrow = 0;
				for (int j = i; j < score.length; j++) {
					if (score[j][k] > highest) {
						highest = score[j][k];
						maxrow = j;
					}
				}
				swaprows(i, maxrow, score);
			}

			return score;
		}

		void swaprows(int r1, int r2, int[][] score) {
			for (int col = 0; col < score[0].length; col++) {
				int temp = score[r1][col];
				score[r1][col] = score[r2][col];
				score[r2][col] = temp;
			}
		}
	}

}
