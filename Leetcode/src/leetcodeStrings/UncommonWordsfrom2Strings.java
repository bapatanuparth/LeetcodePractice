package leetcodeStrings;

import java.util.*;

//A sentence is a string of single-space separated words where each word consists only of lowercase letters.
//
//A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//return all the uncommon words from both the sentences
public class UncommonWordsfrom2Strings {
	
	//better solution using 1 Map
	//put all the frequencies is 1 map and pick only the words that appear once
	 public String[] uncommonFromSentencesEff(String A, String B) {
	        Map<String, Integer> count = new HashMap();
	        for (String word: A.split(" "))
	            count.put(word, count.getOrDefault(word, 0) + 1);
	        for (String word: B.split(" "))
	            count.put(word, count.getOrDefault(word, 0) + 1);

	        List<String> ans = new LinkedList();
	        for (String word: count.keySet())
	            if (count.get(word) == 1)
	                ans.add(word);

	        return ans.toArray(new String[ans.size()]);
	    }

	 public String[] uncommonFromSentences(String s1, String s2) {
	        String[] arr1= s1.split(" ");
	        String[] arr2= s2.split(" ");
	        
	        Map<String, Integer> map=new HashMap<>();
	        for(String s:arr1){
	            map.put(s, map.getOrDefault(s,0)+1);
	        }
	        Map<String, Integer> map2=new HashMap<>();
	        for(String s:arr2){
	            map2.put(s, map2.getOrDefault(s,0)+1);
	        }
	        
	        ArrayList<String> ls=new ArrayList<>();
	        for(String s:map.keySet()){
	            if(!map2.containsKey(s) && map.get(s)==1)ls.add(s);
	        }
	        for(String s:map2.keySet()){
	            if(!map.containsKey(s) && map2.get(s)==1)ls.add(s);
	        }
	        
	        String [] arr=new String[ls.size()];
	        int i=0;
	        for(String s:ls){
	            arr[i]=s;i++;
	        }
	        return arr;
	    }
}
