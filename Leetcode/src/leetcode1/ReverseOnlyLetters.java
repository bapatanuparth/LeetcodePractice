package leetcode1;

//Given a string s, reverse the string according to the following rules:
//
//All the characters that are not English letters remain in the same position.
//All the English letters (lowercase or uppercase) should be reversed.

//Input: s = "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
public class ReverseOnlyLetters {

	  public String reverseOnlyLetters(String s) {
	        int first=0, last=s.length()-1;
	        char[] arr=s.toCharArray();
	        while(first<=last){
	            if(!Character.isLetter(arr[first])){
	                first++;
	                continue;
	            }
	            if(!Character.isLetter(arr[last])){
	                last--;
	                continue;
	            }
	            char ch=arr[first];
	            arr[first]=arr[last];
	            arr[last]=ch;
	            first++;
	            last--;
	        }
	        
	        return new String(arr);
	        
	    }
}
