package leetcode150daysTrie;

//Design a data structure that supports adding new words and finding if a string matches any previously added string.
//
//Implement the WordDictionary class:
//
//WordDictionary() Initializes the object.
//void addWord(word) Adds word to the data structure, it can be matched later.
//bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

public class DesignAddAndSearchWordsDataStructure {

	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}

	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	boolean match(char[] word, int index, TrieNode node) {
		if (index == word.length && node.isWord)
			return true;
		if (index == word.length)
			return false;
		char ch = word[index];
		if (ch == '.') {
			for (int i = 0; i < 26; i++) {
				if (node.children[i] != null) {
					if (match(word, index + 1, node.children[i]))
						return true;
				}
			}
		} else {
			if (node.children[ch - 'a'] == null)
				return false;
			return match(word, index + 1, node.children[ch - 'a']);
		}

		return false;
	}

}
