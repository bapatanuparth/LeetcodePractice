package leetcodeStrings;


//The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s, which is then converted into an integer.
//
//For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.
//
//Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false otherwise.
public class CheckifWordequalsSumof2Words {

	 public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
	        StringBuilder first= new StringBuilder();
	        StringBuilder sec= new StringBuilder();
	        StringBuilder target= new StringBuilder();
	        for(char ch: firstWord.toCharArray()){
	            first.append(ch-'a');
	        }
	        for(char ch: secondWord.toCharArray()){
	            sec.append(ch-'a');
	        }
	        for(char ch: targetWord.toCharArray()){
	            target.append(ch-'a');
	        }
	        long l1=Long.parseLong(first.toString());
	        long l2=Long.parseLong(sec.toString());
	        long l3=Long.parseLong(target.toString());
	        
	        
	        return (l1+l2)==l3;
	    }
}
