package leetcode150daysNumbers;

//Write an algorithm to determine if a number n is happy.
//
//A happy number is a number defined by the following process:
//
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.

public class HappyNumber {

	public int getNext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}

	public boolean isHappy(int n) {
		int slowRunner = n;
		int fastRunner = getNext(n);
		while (fastRunner != 1 && slowRunner != fastRunner) {
			slowRunner = getNext(slowRunner);
			fastRunner = getNext(getNext(fastRunner));
		}
		return fastRunner == 1;
	}

}
