package leetcode150daysBinarySearch;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.

public class KokoEatingBananas {

	public int minEatingSpeed(int[] piles, int h) {
		int max = 0;
		for (int i = 0; i < piles.length; i++) {
			max = Math.max(max, piles[i]);
		}

		int left = 1, right = max;
		int res = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (checkTime(piles, mid) <= h) {
				res = Math.min(res, mid);
				right = mid - 1;
			} else
				left = mid + 1;

		}

		return res;
	}

	long checkTime(int[] piles, int mid) {
		long time = 0;
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] % mid == 0)
				time += piles[i] / mid;
			else {
				time += (piles[i] / mid) + 1;
			}
		}

		return time;
	}

}
