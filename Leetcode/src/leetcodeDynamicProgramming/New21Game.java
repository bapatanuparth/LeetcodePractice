package leetcodeDynamicProgramming;

public class New21Game {

	// see for intuition.
	// gives TLE
	public double new21Game(int n, int k, int maxPts) {
		double[] dp = new double[n + 1]; // dp[i] is the probability of i points
		dp[0] = 1.0;
		// to get i points, we must draw a card, say of points j where 1 <= j<= min(i,
		// maxPts)
		// now, probability of number j == 1/ maxPts.
		// and we reach i from point i-j.
		// hence, for any point i, we must consider all possible values of j from which
		// we can reach i, and sum all the probabilties
		// this will give us combined probability of reaching i from all possible ways
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= maxPts; j++) {
				if (i - j >= 0 && i - j < k) // we dont consider i - j > k because, it doesnt exist. when we reach k
												// points, we need to stop drawing any more cards. when i - j >k, it
												// means we have already reached the point of k and we shouldnt be
												// drawing cards any more
					dp[i] += dp[i - j] / maxPts;
			}
		}
		// to get the probability of k<= i <= n, we need to sum all probabilities in
		// this range
		double ans = 0;
		for (int i = k; i <= n; i++) {
			ans += dp[i];
		}

		return ans;
	}

	// working code
	// If W == 3 and we want to find the probability to get a 5
	// - prob(5) = prob(4) / 3 + prob(3) / 3 + prob(2) /3
	// To generalize:
//    The probability to get point K is
//    p(K) = p(K-1) / W + p(K-2) / W + p(K-3) / W + ... p(K-W) / W
//    
//    let wsum = p(K-1) + p(K-2) + ... + p(K-W)
//    p(K) = wsum / W
	public double new21GameEff(int n, int k, int maxPts) {

		if (k == 0 || n >= k + maxPts)
			return 1;
		double[] dp = new double[n + 1]; // dp[i] is the probability for i points
		dp[0] = 1;
		// we maintain a window of size maxPts
		// for each dp[i] we are essentially considering only values that we can reach i
		// from
		double sum = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = sum / maxPts;
			if (i < k)
				sum += dp[i]; // if K = 21 and maxPts = 10, the eventual point is between 21 and 30
			// To get a point of 27, we can have:
			// - a 20 point with a 7
			// - a 19 point with a 8
			// - a 18 point with a 9
			// - a 17 point with a 10
			// - but cannot have 21 with a 6 or 22 with a 5 because the game already ends
			if (i - maxPts >= 0)
				sum -= dp[i - maxPts];
		}

		double ans = 0;
		for (int i = k; i <= n; i++) {
			ans += dp[i];
		}

		return ans;

	}

}
