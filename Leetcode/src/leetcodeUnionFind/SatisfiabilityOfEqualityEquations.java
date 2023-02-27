package leetcodeUnionFind;
//You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

//
//Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

public class SatisfiabilityOfEqualityEquations {

	public boolean equationsPossible(String[] equations) {

		// create a parent array and inititalize each letter's parent value as self
		int parent[] = new int[26];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		// if a== b, b==c then b's parent will change to a and c's parent also will be a
		// because
		// a==b==c.
		// make this adjustment for each equation that is '=='
		// find out new highest parent for each letter
		for (String eq : equations) {

			char ch = eq.charAt(1);

			if (ch == '=') {

				int var1 = fetchParent(eq.charAt(0) - 'a', parent);
				int var2 = fetchParent(eq.charAt(3) - 'a', parent);
				if (var1 != var2) {
					parent[var2] = var1;
				}
			}
		}

		// now traverse through all '!=' equations, and see if any of the element has
		// same highest grandparent
		// if the elements are seen to have same highest parent it means that the
		// elements have to be same
		// this will invalidate the rule of == ansd we should return false in that case
		for (String eq : equations) {

			char ch = eq.charAt(1);

			if (ch == '!') {

				int var1 = fetchParent(eq.charAt(0) - 'a', parent);
				int var2 = fetchParent(eq.charAt(3) - 'a', parent);
				if (var1 == var2) {
					return false;
				}
			}
		}

		return true;
	}

	// if the index == the letter, then that is the highest parent of the value
	// else call recursively to find out the highest parent of the element
	public int fetchParent(int index, int[] parent) {
		if (parent[index] == index)
			return index;
		return fetchParent(parent[index], parent);
	}
}
