package leetcode150daysSlidingWindow;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		int[] tmap = new int[256];
		int smap[] = new int[256];
		int res = Integer.MAX_VALUE, shash = 0, thash = 0, minLeft = 0, minRight = 0;
		int left = 0;

		for (int i = 0; i < t.length(); i++) {
			tmap[t.charAt(i)]++;
		}

		for (int i = 0; i < s.length(); i++) {
			smap[s.charAt(i)]++;
			if (!match(tmap, smap))
				continue;
			while (left <= i && match(tmap, smap)) {
				if (i - left + 1 < res) {
					minLeft = left;
					minRight = i;
					res = i - left + 1;
				}
				smap[s.charAt(left++)]--;
			}
		}

		return res == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);

	}

	boolean match(int[] tmap, int[] smap) {
		for (int i = 0; i < tmap.length; i++) {
			if (tmap[i] == 0)
				continue;
			if (tmap[i] > smap[i])
				return false;
		}
		return true;
	}
}
