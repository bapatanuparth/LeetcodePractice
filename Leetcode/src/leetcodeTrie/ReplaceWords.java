package leetcodeTrie;

import java.util.List;

//In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
//
//Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
//
//Return the sentence after the replacement.

public class ReplaceWords {

	class TrieNode {
		TrieNode[] children;
		String word;

		TrieNode() {
			children = new TrieNode[26];
		}
	}

	class Solution {
		public String replaceWords(List<String> roots, String sentence) {
			TrieNode trie = new TrieNode();
			for (String root : roots) {
				TrieNode cur = trie;
				for (char letter : root.toCharArray()) {
					if (cur.children[letter - 'a'] == null)
						cur.children[letter - 'a'] = new TrieNode();
					cur = cur.children[letter - 'a'];
				}
				cur.word = root;
			}

			StringBuilder ans = new StringBuilder();

			for (String word : sentence.split("\\s+")) {
				if (ans.length() > 0)
					ans.append(" ");

				TrieNode cur = trie;
				for (char letter : word.toCharArray()) {
					if (cur.children[letter - 'a'] == null || cur.word != null)
						break;
					cur = cur.children[letter - 'a'];
				}
				ans.append(cur.word != null ? cur.word : word);
			}
			return ans.toString();
		}
	}

}
