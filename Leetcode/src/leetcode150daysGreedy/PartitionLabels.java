package leetcode150daysGreedy;

import java.util.ArrayList;
import java.util.List;

//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
//Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//Return a list of integers representing the size of these parts.

public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {
		int[] last = new int[26];
		char[] ch = s.toCharArray();
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < ch.length; i++) {
			last[ch[i] - 'a'] = i;
		}

		int lastmin = 0, count = 0;
		for (int i = 0; i < ch.length; i++) {
			lastmin = Math.max(lastmin, last[ch[i] - 'a']);
			count++;
			if (i == lastmin) {
				ans.add(count);
				count = 0;
			}

		}
		return ans;

	}

}
