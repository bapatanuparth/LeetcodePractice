package leetcode150daysBinarySearch;

public class CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int days) {
		int max = 0;
		int sum = 0;

		for (int i = 0; i < weights.length; i++) {
			max = Math.max(max, weights[i]);
			sum += weights[i];
		}

		int left = max, right = sum;

		int res = sum;
		while (left < right) {
			int mid = left + (right - left) / 2;

			if (isValid(mid, days, weights)) {
				res = Math.min(res, mid);
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return res;
	}

	boolean isValid(int mid, int days, int[] weights) {

		int dayNeeded = 0;
		int currentload = 0;

		for (int i = 0; i < weights.length;) {

			int j = i;
			while (j < weights.length && currentload <= mid) {
				currentload += weights[j];
				if (currentload > mid)
					break;
				j++;
			}

			currentload = 0;
			dayNeeded++;
			i = j;
		}

		return dayNeeded <= days;
	}

}
