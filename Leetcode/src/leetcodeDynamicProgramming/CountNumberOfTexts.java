package leetcodeDynamicProgramming;

//Alice is texting Bob using her phone. The mapping of digits to letters is shown in the figure below.
//
//
//In order to add a letter, Alice has to press the key of the corresponding digit i times, where i is the position of the letter in the key.
//
//For example, to add the letter 's', Alice has to press '7' four times. Similarly, to add the letter 'k', Alice has to press '5' twice.
//Note that the digits '0' and '1' do not map to any letters, so Alice does not use them.
//However, due to an error in transmission, Bob did not receive Alice's text message but received a string of pressed keys instead.
//
//For example, when Alice sent the message "bob", Bob received the string "2266622".
//Given a string pressedKeys representing the string received by Bob, return the total number of possible text messages Alice could have sent.
//
//Since the answer may be very large, return it modulo 109 + 7.

public class CountNumberOfTexts {

	public int countTexts(String p) {
		int dp[] = new int[p.length() + 1];
		int[] dict = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 }; // to store how many letters can be represented by each
																	// of the digit

		// dp[i] = dp[i-1]+dp[i-2]+dp[i-3] and +dp[i-4] for digits 7 or 9
		dp[0] = 1;
		int MOD = 1000000007;

		int n = p.length();
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] % MOD;

			int j = i - 2;
			while (j >= 0 && p.charAt(i - 1) == p.charAt(j) && i - j <= dict[p.charAt(i - 1) - '0']) {
				dp[i] = (dp[i] + dp[j]) % MOD;
				j--;
			}
		}

		return dp[n];
	}

}
