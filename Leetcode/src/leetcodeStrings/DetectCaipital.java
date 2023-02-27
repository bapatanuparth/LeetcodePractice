package leetcodeStrings;

public class DetectCaipital {

	public boolean detectCapitalUse(String word) {
		boolean first = Character.isUpperCase(word.charAt(0));
		boolean lower = false;
		boolean middle = false;

		for (int i = 1; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				if (first == false)
					return false;
				if (lower)
					return false;
				middle = true;
			}

			else if (Character.isLowerCase(word.charAt(i)))
				lower = true;
		}
		if (lower && middle)
			return false;

		return true;
	}

}
