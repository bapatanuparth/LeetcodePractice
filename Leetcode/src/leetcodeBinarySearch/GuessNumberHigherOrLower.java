package leetcodeBinarySearch;

//We are playing the Guess Game. The game is as follows:
//
//I pick a number from 1 to n. You have to guess which number I picked.
//
//Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//
//You call a pre-defined API int guess(int num), which returns three possible results:
//
//-1: Your guess is higher than the number I picked (i.e. num > pick).
//1: Your guess is lower than the number I picked (i.e. num < pick).
//0: your guess is equal to the number I picked (i.e. num == pick).
//Return the number that I picked.
public class GuessNumberHigherOrLower {

	public int guessNumber(int n) {
		int k = guess(n);
		int right = Integer.MAX_VALUE, left = 1;
		while (k != 0 && left <= right) {
			if (k == 0)
				return n;
			if (k < 0) {
				right = n - 1;
				int pivot = left + (right - left) / 2;
				n = pivot;
				k = guess(pivot);
			} else {
				left = n + 1;
				int pivot = left + (right - left) / 2;
				n = pivot;
				k = guess(pivot);
			}
		}

		return n;
	}

	int guess(int num) {

		// returns api telling whether number is high or low
		return 0;
	}
}
