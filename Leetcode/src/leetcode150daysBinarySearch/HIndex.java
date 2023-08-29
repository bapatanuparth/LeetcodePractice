package leetcode150daysBinarySearch;

//Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
//
//According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

public class HIndex {

	public int hIndex(int[] citations) {
		int max = 0;
		for (int i = 0; i < citations.length; i++) {
			max = Math.max(max, citations[i]);
		}
		int ans = 0;
		int left = 0, right = max;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (check(mid, citations)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return ans;
	}

	boolean check(int mid, int[] citations) {
		int count = 0;
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= mid)
				count++;
		}

		return count >= mid;
	}
}
