package leetcodeStrings;
import java.util.*;

//You are given two string arrays words1 and words2.
//
//A string b is a subset of string a if every letter in b occurs in a including multiplicity.
//
//For example, "wrr" is a subset of "warrior" but is not a subset of "world".
//A string a from words1 is universal if for every string b in words2, b is a subset of a.
//
//Return an array of all the universal strings in words1. You may return the answer in any order.
//
 
//Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
//Output: ["facebook","google","leetcode"]
public class WordSubsets {

	
	//Final Solution
	 public List<String> wordSubsetsEff(String[] A, String[] B) {
		 //reduce all the check words to a single word
		 //count all occurrences of all letters and put in a max array
	        int[] bmax = count("");
	        for (String b: B) {
	            int[] bCount = count(b);
	            for (int i = 0; i < 26; ++i)
	                bmax[i] = Math.max(bmax[i], bCount[i]);
	        }

	        List<String> ans = new ArrayList();
	        search: for (String a: A) {
	            int[] aCount = count(a);
	            for (int i = 0; i < 26; ++i)
	                if (aCount[i] < bmax[i])
	                    continue search;
	            ans.add(a);
	        }

	        return ans;
	    }

	    public int[] count(String S) {
	        int[] ans = new int[26];
	        for (char c: S.toCharArray())
	            ans[c - 'a']++;
	        return ans;
	    }

	
	//** this code gives TLE
	 public List<String> wordSubsets(String[] words1, String[] words2) {
	        List<String> result= new ArrayList<>();
	        
	        //iteraate through all words
	        for(int i=0;i<words1.length;i++){
	            String word=words1[i];
	           
	            //iterate through another array of checkwords
	            for(int j=0;j<words2.length;j++){
	                String check=words2[j];
	                StringBuilder sb=new StringBuilder(word);
	                boolean flag=false;
	                
	                //for each character of checkword, see if its in given word
	                for(int k=0;k<check.length();k++){
	                    char ch=check.charAt(k);
	                    
	                    flag=false;
	                    //iterate through each character of present word
	                    for(int l=0;l<sb.length();l++){
	                        char c=sb.charAt(l);
	                        if(c==ch){
	                            sb.setCharAt(l,'1');
	                            flag=true;
	                            break;
	                        }
	                    }
	                    
	                    if(!flag)break;
	                    
	                }
	                if(!flag)break;
	                else if(flag && j==words2.length-1)result.add(word);
	            }
	            
	        }
	        return result;
	    }
	 
	 //this code also gives TLE
	 public List<String> wordSubsets2(String[] words1, String[] words2) {
	        List<String> result= new ArrayList<>();
	        List<Map<Character,Integer>> maps=new ArrayList<>();
	        
	         for(int j=0;j<words2.length;j++){
	                String check=words2[j];
	                Map<Character, Integer> cmap=new HashMap<>();
	            
	                for(char ch:check.toCharArray()){
	                cmap.put(ch, cmap.getOrDefault(ch,0)+1);
	                }
	             maps.add(cmap);
	         }
	        
	        for(int i=0;i<words1.length;i++){
	            String word=words1[i];
	            Map<Character, Integer> map=new HashMap<>();
	            
	            for(char ch:word.toCharArray()){
	                map.put(ch, map.getOrDefault(ch,0)+1);
	            }
	            
	            boolean flag=false;
	            for(Map<Character,Integer> cmap:maps){
	                for(char ch:cmap.keySet()){
	                    flag=false;
	                    if(!map.containsKey(ch)){
	                        flag=false;break;
	                    }
	                    if(map.get(ch)>=cmap.get(ch))flag=true;
	                    else if(map.get(ch)<cmap.get(ch)){
	                        flag=false;break;}
	                }
	                if(!flag)break;
	            }
	            if(flag)result.add(word);
	                
	        }
	        return result;
	    }
	 
}
