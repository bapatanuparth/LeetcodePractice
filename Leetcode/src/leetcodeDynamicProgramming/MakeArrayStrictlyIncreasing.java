package leetcodeDynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import leetcodeDynamicProgramming.MaxLengthChain.Pair;

//Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.
//
//In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].
//
//If there is no way to make arr1 strictly increasing, return -1.

public class MakeArrayStrictlyIncreasing {

	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
		Arrays.sort(arr2);
		int ans = dfs(0, -1, arr1, arr2);
		return ans < 2001 ? ans : -1;
	}

	Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
	// at every point we have 2 choices, whether to replace current element from
	// arr1 eith something from arr2 or go ahead without replacement

	// we need to keep track of the previous element to check whether it is strictly
	// increasing or not
	int dfs(int i, int prev, int arr1[], int arr2[]) {
		if (i == arr1.length) // array length 1, we dont replace, cost == 0
			return 0;

		if (map.containsKey(new Pair<>(i, prev))) // check if we have already done for the pair i, prev
			return map.get(new Pair<>(i, prev));

		int cost = 2001; // stores maximum swaps we might need to do based on arr length

		// first case, if current element > prev element, we directly go ahead without
		// replacement
		if (arr1[i] > prev) {
			cost = dfs(i + 1, arr1[i], arr1, arr2);
		}
		// we get the index from arr2 of the element just bigger than the previous
		// element
		// use binary search for this
		int idx = findNext(arr2, prev);

		// now, if there exists an element in arr2 just bigger than prev, we replace
		if (idx < arr2.length) {
			// this shows we add cost of 1 for replacement and go ahead by making element
			// from arr2 as the new prev element
			cost = Math.min(cost, 1 + dfs(i + 1, arr2[idx], arr1, arr2));
		}

		map.put(new Pair<>(i, prev), cost);
		return cost;

	}

	// binary search for the next bigger element than prev
	int findNext(int arr2[], int prev) {
		int left = 0, right = arr2.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr2[mid] <= prev)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return left;
	}

}
