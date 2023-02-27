package leetcodeStrings;
import java.util.*;
//Given a string array words, return an array of all characters that show up in all strings
//within the words (including duplicates). You may return the answer in any order.

//Input: words = ["bella","label","roller"]
//Output: ["e","l","l"]

//Input: words = ["cool","lock","cook"]
//Output: ["c","o"]
public class FindCommonChars {

	 public List<String> commonChars(String[] words) {
	        List<String>res=new ArrayList<>();
	        for(int i=0;i<words[0].length();i++){
	            char ch=words[0].charAt(i);
	            int count=1;
	            for(int j=1;j<words.length;j++){
	                String s=words[j];
	                for(int k=0;k<s.length();k++){
	                    char c=s.charAt(k);
	                    if(c==ch){
	                        StringBuilder sb=new StringBuilder(s);
	                        sb.setCharAt(k,'1');
	                        words[j]=sb.toString();
	                        count++;
	                        break;
	                    }
	                }
	            }
	            if(count==words.length){
	                res.add(""+ch);   }
	        }
	          return res;

	    }
}
