package leetcode1;

import java.util.HashSet;
import java.util.Set;

//A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') 
//and has all five vowels present in it.
//Given a string word, return the number of vowel substrings in word.

public class CountVowelsSubstrings {
	 public int countVowelSubstrings(String word) {
	        int n=word.length(),j=0;
	        Set<Character> set=new HashSet<>();
	        int res=0;
	        for(int i=0;i<n-4;i++){
	            set.clear();
	            j=i;
	            while(j<n){
	                char ch=word.charAt(j);
	                if(ch=='a' ||ch=='e' ||ch=='i' ||ch=='o' ||ch=='u'){
	                    set.add(ch);
	                    if(set.size()==5)res++;
	                    j++;
	                }
	                else break;
	            }
	        }
	        return res;
	    }
}
