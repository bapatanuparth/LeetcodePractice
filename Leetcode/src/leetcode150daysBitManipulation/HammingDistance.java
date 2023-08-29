package leetcode150daysBitManipulation;

public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			int lsbx = (1 << i) & x;
			int lsby = (1 << i) & y;
			if (lsbx != lsby)
				count++;
		}

		return count;
	}

}
