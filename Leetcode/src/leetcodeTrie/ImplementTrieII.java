package leetcodeTrie;

class TrieNode {
	TrieNode[] children;
	boolean isEnd;
	int countWords;

	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class ImplementTrieII {

	// count wrapper to track words starting with a given prefix
	class Count {
		int count;

		public Count() {
			count = 0;
		}
	}

	TrieNode root;

	public ImplementTrieII() {
		root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (p.children[ch - 'a'] == null) {
				p.children[ch - 'a'] = new TrieNode();
			}
			p = p.children[ch - 'a'];
		}
		p.isEnd = true;
		p.countWords++;
	}

	public int countWordsEqualTo(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (p.children[ch - 'a'] == null) {
				return 0;
			}
			p = p.children[ch - 'a'];
		}
		if (p.isEnd == true)
			return p.countWords;
		else
			return 0;

	}

	public int countWordsStartingWith(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (p.children[ch - 'a'] == null) {
				return 0;
			}
			p = p.children[ch - 'a'];
		}

		Count co = new Count();
		countWordsStarting(p, co);
		return co.count;
	}

	void countWordsStarting(TrieNode p, Count c) {

		if (p.isEnd == true) {
			c.count += p.countWords;
		}
		for (int i = 0; i < 26; i++) {
			if (p.children[i] != null) {

				countWordsStarting(p.children[i], c);
			}
		}
	}

	public void erase(String word) {
		TrieNode p = root;

		deleteUtil(p, word, 0);
	}

	TrieNode deleteUtil(TrieNode root, String word, int i) {
		if (root == null)
			return null;
		if (i == word.length()) {

			if (root.countWords == 1) {

				root.isEnd = false;
				root.countWords = 0;// if we want to remove CAT and there is another word CATER in the dictionary
				// we just want to mark CAT node's isEnd==false

				if (isEmpty(root)) { // means that there is no children of root, it can be made null
					root = null;
				}
			} else {
				root.countWords--;
			}
			return root;

		}
		int index = word.charAt(i) - 'a'; // if we havent reached till the end of the word to be removed, go down the
											// recursion tree
		root.children[index] = deleteUtil(root.children[index], word, i + 1);
		if (isEmpty(root) && root.isEnd == false) { // when we want to remove "GEEKS", we reach till the end, start
													// removeing in reverse order
			// isEnd== false ensures that there is not prefix of GEEKS in dictionary
			// because if there is a prefix, we dont want to remove that
			root = null;
		}
		return root;

	}

	boolean isEmpty(TrieNode root) {
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null)
				return false;
		}
		return true;
	}
}
