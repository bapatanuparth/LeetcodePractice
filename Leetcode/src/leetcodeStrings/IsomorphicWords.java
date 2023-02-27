package leetcodeStrings;
import java.util.*;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. 
//No two characters may map to the same character, but a character may map to itself.

//Input: s = "egg", t = "add"
//Output: true
public class IsomorphicWords {
	
	//2 arrays to map chars
	 public boolean isIsomorphic3(String s, String t) {
	        
	        int[] mappingDictStoT = new int[256];
	        Arrays.fill(mappingDictStoT, -1);
	        
	        int[] mappingDictTtoS = new int[256];
	        Arrays.fill(mappingDictTtoS, -1);
	        
	        for (int i = 0; i < s.length(); ++i) {
	            char c1 = s.charAt(i);
	            char c2 = t.charAt(i);
	            
	            // Case 1: No mapping exists in either of the dictionaries
	            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
	                mappingDictStoT[c1] = c2;
	                mappingDictTtoS[c2] = c1;
	            }
	            
	            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
	            // it doesn't match in either of the dictionaries or both 
	            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
	                return false;
	            }
	        }
	        return true;
	 }
	
	
	//hashmap and hashset
	public boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map.containsKey(ch1) == false){
                if(hs.contains(ch2) == false){
                    map.put(ch1, ch2);
                    hs.add(ch2);
                } else{
                    return false;
                }
            } else if(map.get(ch1).equals(ch2) == false){
                return false;
            }
        }
        return true;
    }
	
	//using 2 hashmaps
	 public boolean isIsomorphic(String s, String t) {
         int a=1;
        Map<Character, Integer> map1= new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map1.containsKey(c))
            {
                map1.put(c,a);
                a++;
            }
        }
        a=1;
        Map<Character, Integer> map2= new HashMap<>();
        for(char temp: t.toCharArray()){
            if(!map2.containsKey(temp))
            {
                map2.put(temp,a);
                a++;
            }
        }
        StringBuilder sb1= new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        for(char c: s.toCharArray()){
            sb1.append(map1.get(c));
        }
   
        for(char temp: t.toCharArray()){
            sb2.append(map2.get(temp));
        }
        
        return sb1.toString().equals(sb2.toString());
	 }

}
