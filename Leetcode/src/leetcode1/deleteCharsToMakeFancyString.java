package leetcode1;


//A fancy string is a string where no three consecutive characters are equal.
//
//Given a string s, delete the minimum possible number of characters from s to make it fancy.
public class deleteCharsToMakeFancyString {

	  public String makeFancyString(String s) {
	        int count=1;
	        StringBuilder sb=new StringBuilder();
	        sb.append(s.charAt(0));
	        for(int i=1;i<s.length();i++){
	            if(s.charAt(i-1)==s.charAt(i)){
	                count++;}
	            else count=1;
	            if(count==3){
	                count--;
	            }
	            else sb.append(s.charAt(i));
	            
	        }
	        return sb.toString();
	    }
}
