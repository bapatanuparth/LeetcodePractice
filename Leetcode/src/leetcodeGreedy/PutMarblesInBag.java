package leetcodeGreedy;

import java.util.Arrays;

//You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.
//
//Divide the marbles into the k bags according to the following rules:
//
//No bag is empty.
//If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
//If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
//The score after distributing the marbles is the sum of the costs of all the k bags.
//
//Return the difference between the maximum and minimum scores among marble distributions.

public class PutMarblesInBag {

	public long putMarbles(int[] weights, int k) {
		int n = weights.length;
		if (k == n)
			return 0;
		int[] pairWeights = new int[n - 1];
		// get all possible cuts that can be made at each ith location.
		// when a cut is made at ith location, its previous and next are the only 2
		// elements that are added to the sum
		for (int i = 0; i < n - 1; i++) {
			pairWeights[i] = weights[i] + weights[i + 1];
		}
		// sort the sums
		// so for maximum sum, we can pick largest k-1 cuts
		// for minimum sum, we can pick smallest k-1 cuts
		Arrays.sort(pairWeights);
		return max(pairWeights, k - 1) - min(pairWeights, k - 1);

	}

	long max(int[] W, int k) {
		int n = W.length;
		long res = 0;
		for (int i = n - 1; i >= n - k; i--) {
			res += W[i];
		}
		return res;
	}

	long min(int[] W, int k) {
		long res = 0;
		for (int i = 0; i < k; i++)
			res += W[i];
		return res;
	}

}
