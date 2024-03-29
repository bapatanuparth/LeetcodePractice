package leetcodeTrie;

import java.util.ArrayDeque;
import java.util.Queue;

public class LongestCommonSuffixQueries {

	class TrieNode {
		TrieNode[] children;
		String word;
		int index; // save index to easily get the index of the matched word

		public TrieNode() {
			this.children = new TrieNode[26];
			this.word = null;
			this.index = Integer.MAX_VALUE;
		}

		@Override
		public String toString() {
			return "" + index; // easy to debug
		}
	}

	TrieNode dict;

	public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
		dict = new TrieNode();

		// add every word from the word dictionary in Trie
		for (int i = 0; i < wordsContainer.length; i++) {
			String w = wordsContainer[i];
			addWord(w, i);
		}

		int[] res = new int[wordsQuery.length];

		for (int i = 0; i < wordsQuery.length; i++) {
			String q = wordsQuery[i];

			res[i] = getSmallestSuffix(q);

		}

		return res;
	}

	void addWord(String word, int ind) {
		// add a word in reverse order in the Trie
		TrieNode temp = dict;
		for (int i = word.length() - 1; i >= 0; i--) {
			char ch = word.charAt(i);
			if (temp.children[ch - 'a'] == null) {
				temp.children[ch - 'a'] = new TrieNode();
			}
			temp = temp.children[ch - 'a'];
		}
		temp.word = word;
		temp.index = Math.min(temp.index, ind);
	}

	int getSmallestSuffix(String word) {
		TrieNode temp = dict;
		int i = word.length() - 1;
		// move further till we go down the trie for all the common suffix characters
		while (i >= 0 && temp.children[word.charAt(i) - 'a'] != null) {
			temp = temp.children[word.charAt(i) - 'a'];
			i--;
		}
		if (temp.index != Integer.MAX_VALUE)
			return temp.index; // this means exact matching word was found
		return searchAllRemaining(temp);
	}

	int searchAllRemaining(TrieNode temp) {
		// perform BFS on the trieNode to check the smallest matching string
		Queue<TrieNode> q = new ArrayDeque<>();
		q.offer(temp);

		while (!q.isEmpty()) {
			int ans = Integer.MAX_VALUE;
			int s = q.size();
			while (s > 0) {
				TrieNode t = q.poll();
				if (t.index != Integer.MAX_VALUE)
					ans = Math.min(ans, t.index);
				for (int i = 0; i < 26; i++) {
					if (t.children[i] != null) {
						q.offer(t.children[i]);
					}
				}
				s--;
			}
			// this means we have found the smallest word in this level
			if (ans != Integer.MAX_VALUE)
				return ans;
		}
		return 0;
	}

}
