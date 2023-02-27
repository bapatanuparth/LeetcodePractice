package leetcodeStrings;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
//
//Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.
//
//For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
//There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
//
//Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.
//
//Note that the starting point is assumed to be valid, so it might not be included in the bank.

public class MinGeneticMutations {

	// use BFS
	public int minMutation(String start, String end, String[] bank) {

		// fetch all the strings in bank
		if (start.equals(end))
			return 0;
		Set<String> bankSet = new HashSet<>();

		for (String s : bank)
			bankSet.add(s);

		// create a visited set to keep track of which one are visited
		Set<String> visited = new HashSet<>();
		visited.add(start);
		Queue<String> q = new ArrayDeque<>();
		q.add(start);

		char[] chars = new char[] { 'A', 'C', 'G', 'T' };
		int level = 0;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				// for a string, change each character from 1st to last e=index with all 4
				// possible characters
				String curr = q.poll();
				if (curr.equals(end)) // return if end is reached
					return level;

				char[] word = curr.toCharArray();

				for (int j = 0; j < word.length; j++) {
					char old = word[j];

					// change characters one by one
					for (char ch : chars) {
						word[j] = ch;
						String next = new String(word);

						// if the new string so formed is present in bank and not visited, add it in the
						// queue
						// next time this string will be our starting point and we will again check for
						// changes and check if end is found
						// this way we check all possible combinations and go step by step near the
						// output
						if (!visited.contains(next) && bankSet.contains(next)) {
							visited.add(next);
							q.offer(next);
						}

					}

					word[j] = old;
				}

			}

			level++;

		}
		return -1;

	}
}
