package leetcode1;
//Given a string s consisting of some words separated by some number of spaces, 
//return the length of the last word in the string.

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
//        String str="   fly me   to   the moon  ";
        int i=s.length()-1;
        int count=0;
        boolean flag=false;
        while(i>=0) {
        	System.out.println(s.charAt(i));
        	if(s.charAt(i)==' ' && flag==false) { i--;continue;}
        	else if(s.charAt(i)==' ' && flag==true)break;
        	else {
        		flag=true;
        		count++;
        		i--;
        	}
        }
        System.out.println(count);
        return count;
    }
    
    public static void main(String[] args) {
    	lengthOfLastWord("");
	}
	
}
