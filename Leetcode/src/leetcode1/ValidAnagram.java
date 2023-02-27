package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	
	//cool and fast solution -->
	public boolean isAnagram2(String s, String t) {
		int[] hash=new int[26];
		for(char c:s.toCharArray()) {
			++hash[c-'a'];
		}
		for(char c:t.toCharArray()) {
			--hash[c-'a'];
		}
		for(int i:hash) {
			if(i!=0)return false;
		}
		return true;
	}
	
	//naive solution -->
    public boolean isAnagram(String s, String t) {
    	Map<Character, Integer>map1=new HashMap<>();
    	Map<Character, Integer>map2=new HashMap<>();
    	int value=0;
        for(int i=0;i<s.length();i++) {
        	if(map1.containsKey(s.charAt(i)))
          		 map1.replace(s.charAt(i), map1.get(s.charAt(i))+1);
          	 else map1.put(s.charAt(i), value+1);
        }
        for(int i=0;i<t.length();i++) {
        	if(map2.containsKey(t.charAt(i)))
          		 map2.replace(t.charAt(i), map2.get(t.charAt(i))+1);
          	 else map2.put(t.charAt(i), value+1);
        }
        return map1.equals(map2);
    }

}
