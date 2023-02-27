package leetcodeInterviewPrep;

public class SumOfTwoIntegers {

//	Simplify problem down to two cases: sum or subtraction of two positive integers: x \pm yx±y, where x > yx>y. Save down the sign of the result.
//
//	If one has to compute the sum:
//
//	While carry is nonzero: y != 0:
//
//	Current answer without carry is XOR of x and y: answer = x^y.
//
//	Current carry is left-shifted AND of x and y: carry = (x & y) << 1.
//
//	Job is done, prepare the next loop: x = answer, y = carry.
//
//	Return x * sign.
//
//	If one has to compute the difference:
//
//	While borrow is nonzero: y != 0:
//
//	Current answer without borrow is XOR of x and y: answer = x^y.
//
//	Current borrow is left-shifted AND of NOT x and y: borrow = ((~x) & y) << 1.
//
//	Job is done, prepare the next loop: x = answer, y = borrow.
//
//	Return x * sign.
	public int getSum(int a, int b) {

		int x = Math.abs(a), y = Math.abs(b);

		if (x < y)
			return getSum(b, a);

		int sign = a > 0 ? 1 : -1;

		if (a * b > 0) // both positive/ negative, add both numbers
		{
			while (y != 0) {
				int answer = x ^ y;
				int carry = (x & y) << 1;
				x = answer;
				y = carry;

			}
		} else { // one positive another negative, subtract the numbers
			while (y != 0) {
				int answer = x ^ y;
				int borrow = ((~x) & y) << 1;
				x = answer;
				y = borrow;
			}
		}

		return x * sign;
	}
}
