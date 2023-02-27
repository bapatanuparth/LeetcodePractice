package leetcodeStrings;

//You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
//
//We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
//
//If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
//For example, the word "apple" becomes "applema".
//If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
//For example, the word "goat" becomes "oatgma".
//Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
//Return the final sentence representing the conversion from sentence to Goat Latin.

//Input: sentence = "I speak Goat Latin"
//Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
public class ConvertToGoatLatin {

	 public String toGoatLatin(String sentence) {
	        String [] str= sentence.split(" ");
	        StringBuilder res= new StringBuilder();
	        for(int i=0;i<str.length;i++){
	            String s=str[i];
	            StringBuilder temp= new StringBuilder();
	            if(s.charAt(0)=='a' || s.charAt(0)=='e' || s.charAt(0)=='i' || s.charAt(0)=='o' || s.charAt(0)=='u' || s.charAt(0)=='A' || s.charAt(0)=='E' || s.charAt(0)=='I' || s.charAt(0)=='O' || s.charAt(0)=='U' ){
	                temp.append(s);
	                temp.append("ma");
	            }
	            else{
	                temp.append(s.substring(1,s.length()));
	                temp.append(s.charAt(0));
	                temp.append("ma");
	                
	            }
	            for(int j=0;j<=i;j++){
	                temp.append("a");
	            }
	            res.append(temp);
	            if(i!=str.length-1)
	                res.append(" ");
	        }
	        return res.toString();
	    }
}
