package leetcode1;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}
   static public boolean isPalindrome(int x) {
        int y=0;
        int temp=x;
        while(x!=0) {
        	y=(y+x%10);
        	if(x/10!=0)
        		y=y*10;
        	x=x/10;
        }
        return (temp==y);
    }
}
