package leetcodeHash;

public class FindSmallestCommonElementAllRows {

	public int smallestCommonElement(int[][] mat) {
		// max value of element in matrix is 10000
		int[] arr = new int[10001];

		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j < mat[0].length; j++) {
				// count frequency of occurrence of each element
				arr[mat[i][j]]++;
			}
		}

		// find the first element whose value == # rows of matrix as there are no
		// duplicates allowed in a row
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == mat.length)
				return i;
		}
		return -1;
	}
}
