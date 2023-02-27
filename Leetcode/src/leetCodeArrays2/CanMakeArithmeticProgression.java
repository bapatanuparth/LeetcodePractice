package leetCodeArrays2;
//A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

//
//Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

public class CanMakeArithmeticProgression {

	public boolean canMakeArithmeticProgression(int[] arr) {
		int n = arr.length;

		int min1 = 9999998;
		int min2 = 9999999;
		for (int j : arr) {
			if (j <= min1) {
				min2 = min1;
				min1 = j;
			} else if (j <= min2) {
				min2 = j;
			}
		}

		int duration = min2 - min1;

		if (duration == 0) {
			for (int j : arr) {
				if (j != arr[0])
					return false;
			}
			return true;
		}

		boolean[] pres = new boolean[n];
		for (int j : arr) {
			int idx = (j - min1) / duration;

			if (idx >= 0 && idx < n)
				pres[idx] = true;
		}

		for (int i = 0; i < n; i++)
			if (!pres[i])
				return false;

		return true;
	}

}
