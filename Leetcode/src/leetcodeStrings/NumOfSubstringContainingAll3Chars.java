package leetcodeStrings;


//tricky problem

//Given a string s consisting only of characters a, b and c.
//
//Return the number of substrings containing at least one occurrence of all these characters a, b and c.
//
//Input: s = "abcabc"
//Output: 10
//
//Input: s = "aaacb"
//Output: 3
public class NumOfSubstringContainingAll3Chars {

	public int numberOfSubstrings(String s) {
        int[] track= new int[3];
        int res=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            track[s.charAt(i)-'a']++;
            while(track[0]>0 && track[1]>0 && track[2]>0){
                res+=s.length()-i;
                track[s.charAt(left++)-'a']--;
            }
        }
        return res;
    }
}

