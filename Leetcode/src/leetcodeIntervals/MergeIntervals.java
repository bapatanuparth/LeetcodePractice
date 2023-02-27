package leetcodeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public int[][] merge(int[][] arr) {
		List<int[]> res = new ArrayList<>();
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		int a = arr[0][0], b = arr[0][1];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] > b) {
				res.add(new int[] { a, b });
				a = arr[i][0];
				b = arr[i][1];
			} else {
				b = Math.max(b, arr[i][1]);
			}
		}
		res.add(new int[] { a, b });

		return res.toArray(new int[res.size()][]);

	}
}
