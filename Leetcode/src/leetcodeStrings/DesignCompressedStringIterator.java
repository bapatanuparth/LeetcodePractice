package leetcodeStrings;

//Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
//
//Implement the StringIterator class:
//
//next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
//hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.

//["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
//[["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
//Output
//[null, "L", "e", "e", "t", "C", "o", true, "d", true]

public class DesignCompressedStringIterator {

//	next(): We make use of a global pointer ptrptr to keep a track of which compressed letter in the 
	// compressedStringcompressedString needs to be processed next. We also make use
	// of a global variable
	// numnum to keep a track of the number of instances of the current letter which
	// are still pending.
	// Whenever next() operation needs to be performed, firstly, we check if there
	// are more uncompressed letters
	// left in the compressedStringcompressedString. If not, we return a ' '.
	// Otherwise, we check if there are
//	more instances of the current letter still pending. If so, we directly decrement the count of instances 
//	indicated by numsnums and return the current letter. But, if there aren't more instances pending for the
//			current letter, we update the ptrptr to point to the next letter in the
//			compressedStringcompressedString. We also update the numnum by obtaining the count for the next
//			letter from the compressedStringcompressedString. This number is obtained by making use of decimal 
//			arithmetic
	int count = 0, ptr = 0;
	String res;
	char ch = ' ';

	public DesignCompressedStringIterator(String compressedString) {
		res = compressedString;
	}

	public char next() {
		if (!hasNext())
			return ' ';
		if (count == 0) {
			ch = res.charAt(ptr++);
			while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
				count = count * 10 + res.charAt(ptr++) - '0';
			}
		}
		count--;
		return ch;
	}

	public boolean hasNext() {
		return ptr != res.length() || count != 0;
	}
}
