package leetcode150daysStackAndQueue;

//Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
//
//Note that after backspacing an empty text, the text will continue empty.

public class BackspaceStringCompare {

	public boolean backspaceCompare(String s, String t) {

		int spointer = s.length() - 1;
		int tpointer = t.length() - 1;
		int skips = 0, skipt = 0;

		// traverse string in reverse order
		// if we find a # skip the next element
		while (spointer >= 0 || tpointer >= 0) {
			while (spointer >= 0) {
				if (s.charAt(spointer) == '#') {
					skips++;
					spointer--;
				} else if (skips > 0) {
					spointer--;
					skips--;
				} else
					break;
			}
			while (tpointer >= 0) {
				if (t.charAt(tpointer) == '#') {
					skipt++;
					tpointer--;
				} else if (skipt > 0) {
					tpointer--;
					skipt--;
				} else
					break;
			}

			if (spointer >= 0 && tpointer >= 0 && s.charAt(spointer) != t.charAt(tpointer))
				return false;
			if ((spointer >= 0) != (tpointer >= 0))
				return false;
			spointer--;
			tpointer--;
		}

		return true;
	}
}
