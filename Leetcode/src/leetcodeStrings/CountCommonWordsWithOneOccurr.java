package leetcodeStrings;

import java.util.HashMap;
import java.util.Map;

//Given two string arrays words1 and words2,
//return the number of strings that appear exactly once in each of the two arrays.

public class CountCommonWordsWithOneOccurr {

	public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1=new HashMap<>();
        Map<String, Integer> map2=new HashMap<>();
        
        int res=0;
        for(String s:words1){
            map1.put(s, map1.getOrDefault(s,0)+1);
        }
        for(String s:words2){
            map2.put(s, map2.getOrDefault(s,0)+1);
        }
        
        for(int i=0;i<words2.length;i++){
            if(map1.containsKey(words2[i]) && map1.get(words2[i])==1 && map2.get(words2[i])==1)
                res++;
        }
        return res;
    }
}
