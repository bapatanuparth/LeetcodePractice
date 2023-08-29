package leetcode150daysBitManipulation;

public class ReverseBits {

	public int reverseBits(int n) {
		int reversedN = 0;
		for (int i = 0; i < 32; i++) {
			int bit = (n >> i) & 1;
			reversedN |= bit << (31 - i);
		}

		return reversedN;
	}

}
