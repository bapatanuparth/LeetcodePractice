package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an array of strings strs, group the anagrams together.
//You can return the answer in any order.
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class GroupAnagrams {
	
	//very very good and intuitive solution
	 public List<List<String>> groupAnagramsEff(String[] strs) {
	        HashMap<HashMap<Character,Integer>,ArrayList<String>> map=new HashMap<>();
	        for(String s:strs){
	            HashMap<Character,Integer> fmap=new HashMap<>();
	            for(int i=0;i<s.length();i++){
	                char ch=s.charAt(i);
	                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
	            }
	            if(map.containsKey(fmap)){
	                map.get(fmap).add(s);
	            }else{
	                ArrayList<String> list=new ArrayList<>();
	                list.add(s);
	                map.put(fmap,list);
	            }
	        }
	        List<List<String>> ans=new ArrayList<>();
	        for(ArrayList<String> list:map.values()){
	            ans.add(list);
	        }
	        return ans;
	    }

	
	//Naive solution not good-->
	public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
		List<String> temp=new ArrayList<>();
		List<String> val;
		List<List<String>>res=new ArrayList<>();
		for(int i=0;i<strs.length;i++) {
			temp.add(sortString(strs[i]));
		}
		int count=0;
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<temp.size();i++) {
			if(map.containsKey(temp.get(i))) {
				val=res.get(map.get(temp.get(i)));
				val.add(strs[i]);
				System.out.println(res);
			}
			else
				{
				List<String> s=new ArrayList<String>();
				s.add(strs[i]);
				res.add(s);
				map.put(temp.get(i),count);
				count++;
				}
				
		}
		System.out.println(res);
		return res;
    }
    public static void main(String[] args) {
		String[] strs= {"eat","tea","tan","ate","nat","bat"};

		
			
			
		
			
	}
}
