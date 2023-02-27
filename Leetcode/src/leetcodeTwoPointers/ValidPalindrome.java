package leetcodeTwoPointers;
//
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//

//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
public class ValidPalindrome {

	 public boolean isPalindrome(String s) {
	        
	        char[] arr= s.toCharArray();
	        int left=0, right=arr.length-1;
	        
	        //any alphanumeric shouuld be ignored in the check
	        while(left<=right){
	            
	            
	            if(!Character.isLetter(arr[left]) && !Character.isDigit(arr[left]))
	            {
	                left++;
	                continue;
	            }
	            if(!Character.isLetter(arr[right]) && !Character.isDigit(arr[right]))
	            {
	                right--;
	                continue;
	            }                                                     if(Character.toLowerCase(arr[left])!=Character.toLowerCase(arr[right]))
	                return false;
	            else if(Character.toLowerCase(arr[left])==Character.toLowerCase(arr[right])){
	                left++;right--;
	            }
	        }
	        
	        return true;
	    }
}
