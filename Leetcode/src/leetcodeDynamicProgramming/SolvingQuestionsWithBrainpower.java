package leetcodeDynamicProgramming;

//You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
//
//The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
//
//For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
//If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
//If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
//Return the maximum points you can earn for the exam.
public class SolvingQuestionsWithBrainpower {

	// for each question, store the max points we can earn by starting on that
	// question
	// if we skip the question, the answer for that question == ans for the next
	// question
	// if we take the current question, ans for that question == curr points +
	// points for the next valid question
	// traverse in reverse order

	public long mostPoints(int[][] questions) {
		long[] dp = new long[questions.length];
		int n = questions.length;
		dp[n - 1] = questions[n - 1][0];

		for (int i = n - 2; i >= 0; i--) {
			int[] q = questions[i];
			dp[i] = q[0];
			if (i + q[1] + 1 < n) {
				dp[i] += dp[i + q[1] + 1];
			}
			dp[i] = Math.max(dp[i], dp[i + 1]);
		}

		return dp[0];

	}

}
