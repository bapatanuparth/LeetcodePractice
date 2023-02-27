package leetcodeStrings;
import java.util.*;

//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s

//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
public class WordPattern {

	public boolean wordPattern(String pattern, String s) {
        String [] str= s.split(" ");
        
        int a=1;
        Map<Character, Integer> map1= new HashMap<>();
        for(char c: pattern.toCharArray()){
            if(!map1.containsKey(c))
            {
                map1.put(c,a);
                a++;
            }
        }
        a=1;
        Map<String, Integer> map2= new HashMap<>();
        for(String temp: str){
            if(!map2.containsKey(temp))
            {
                map2.put(temp,a);
                a++;
            }
        }
        StringBuilder sb1= new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        for(char c: pattern.toCharArray()){
            sb1.append(map1.get(c));
        }
   
        for(String temp: str){
            sb2.append(map2.get(temp));
        }
        
        return sb1.toString().equals(sb2.toString());
        
    }
}
