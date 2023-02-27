package leetcodeBitManipulation;

//Given an integer n, return true if it is a power of two. Otherwise, return false.
//
//An integer n is a power of two, if there exists an integer x such that n == 2x.
public class CheckIfNumberIsPowerOfTwo {

//	Example : N = 5 (not a power of 2)
//			5 in binary = 101
//			5-1 => 4 in binary = 100
//			now, (5 & (4)) => will not be equal to 0, thats why N = 5 is not a power of 2.
//			similarly you can check for other numbers also.

	public boolean isPowerOfTwo(int n) {
		return (n > 0 && (n & (n - 1)) == 0);
	}
}
