package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	// view it as simple BFS problem
	// we are asked to find shortest distance from source word to destination word
	// using wordlisty
	// fetch every word from queue. try changing every letter one by one and check
	// which word we have in our wordlist
	// if we have that word, add it in queue and go ahead.count number of changes we
	// made after each queue remooving cycle
	// return the ans when word matches endword

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord))
			return 0;

		Set<String> visited = new HashSet<>();
		Queue<String> q = new ArrayDeque<>();
		q.add(beginWord);
		visited.add(beginWord);

		int changes = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				String str = q.poll();
				if (str.equals(endWord))
					return changes;

				for (int j = 0; j < str.length(); j++) {
					for (char k = 'a'; k <= 'z'; k++) {
						char[] arr = str.toCharArray();
						arr[j] = k;
						String s = new String(arr);
						if (!visited.contains(s) && set.contains(s)) {
							q.add(s);
							visited.add(s);
						}
					}
				}
			}

			++changes;
		}

		return 0;
	}

}
