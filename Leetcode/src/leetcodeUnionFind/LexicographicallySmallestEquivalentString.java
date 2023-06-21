package leetcodeUnionFind;

//You are given two strings of the same length s1 and s2 and a string baseStr.
//
//We say s1[i] and s2[i] are equivalent characters.
//
//For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
//Equivalent characters follow the usual rules of any equivalence relation:
//
//Reflexivity: 'a' == 'a'.
//Symmetry: 'a' == 'b' implies 'b' == 'a'.
//Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
//For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
//
//Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

public class LexicographicallySmallestEquivalentString {

	int[] parent = new int[26];

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		// assign each character's parent as itself
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		// perform union operation for the 2 equivalent characters
		for (int i = 0; i < s1.length(); i++) {
			int chara = s1.charAt(i) - 'a';
			int charb = s2.charAt(i) - 'a';
			union(chara, charb);
		}

		String ans = "";

		for (char ch : baseStr.toCharArray()) {
			int c = find(ch - 'a');
			ans += (char) (c + 'a');
		}

		return ans;
	}

	// find parent of x
	int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	// union of 2 nodes
	void union(int x, int y) {
		// fnd parents of x and y
		int px = find(x);
		int py = find(y);
		// if same parent, return
		if (px == py)
			return;
		if (px < py) // we want lexicographically smaller string,
			// so we make the smaller element == parent of bigger element
			parent[py] = px;
		else
			parent[px] = py;
	}

}
