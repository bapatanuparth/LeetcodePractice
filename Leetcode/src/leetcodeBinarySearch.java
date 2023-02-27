import java.util.Arrays;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.

//Input: piles = [3,6,7,11], h = 8
//Output: 4
public class leetcodeBinarySearch {

	public int minEatingSpeed(int[] piles, int h) {

		Arrays.sort(piles);
		int low = 1, high = piles[piles.length - 1];
		int res = Integer.MAX_VALUE;

		// perform binary search for 1 ... highest element of the array
		while (low <= high) {
			int mid = (low + high) / 2;

			int count = 0;
			int i = 0;
			// count the total number of hours required to eat bananas if we take speed ==
			// high/2
			// if the hours req > hours given, move towards right , i.e eat bananas faster
			// if hours req <= hours given, move towards left i.e. eat banans slower, or see
			// if we can eat slower

			for (i = 0; i < piles.length; i++) {

				int temp = (piles[i] + mid - 1) / mid; // calculate ceiling after division, we dont want floor

				if (temp == 0)
					temp = 1; // if arr[i]< rate, it will be finished in 1 hour
				count += temp; // count # of hours taken with this speed

				if (count > h) { // if #hours > h, we need to go faster
					low = mid + 1;
					break;
				}
			}

			if (count <= h) {
				res = Math.min(res, mid);
				high = mid - 1;
			}

		}

		return res;

	}
}
