package leetcode1;

//Return true if it is possible to make both strings equal by performing at most 
//one string swap on exactly one of the strings. Otherwise,return false.

public class StringCharacterSwapCheck {

	 public boolean areAlmostEqual(String s1, String s2) {
	        if(s1.equals(s2))return true;
	        int count=0;
	        int first=-1, second=-1;
	        for(int i=0;i<s1.length();i++){
	            if(count>2)return false;
	            if(s1.charAt(i)!=s2.charAt(i)){
	                count++;
	                if(first!=-1){
	                    second=i;
	                }else first=i;
	            }
	        }
	        if(count==2)
	        {
	            if(s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first)){
	                return true;
	            }
	            else return false;
	        }else return false;
	    }
}
