package leetcode150daysBitManipulation;

import java.math.BigInteger;

//Given two binary strings a and b, return their sum as a binary string.

public class AddBinary {

	public String addBinary(String a, String b) {
		BigInteger x = new BigInteger(a, 2);
		BigInteger y = new BigInteger(b, 2);
		BigInteger zero = new BigInteger("0", 2);
		BigInteger carry, answer;
		while (y.compareTo(zero) != 0) {
			answer = x.xor(y); // x or will give us addition without carry
			carry = x.and(y).shiftLeft(1);// carried element
			x = answer;
			y = carry;
		}
		return x.toString(2);
	}
}
