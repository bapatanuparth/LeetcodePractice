package leetcode1;

//Given two non-negative integers, num1 and num2 represented as string,
//return the sum of num1 and num2 as a string.
public class AddString {

    public static String addStrings(String num1, String num2) {
        StringBuilder res=new StringBuilder();
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        int carry=0;
        while(len1>=0 || len2>=0) {
        	int sum=carry;
        	if(len1>=0)sum=sum+(num1.charAt(len1)-'0');
        	if(len2>=0)sum=sum+(num2.charAt(len2)-'0');
        	res.append(sum%10);
        	carry=sum/10;
        	len1--;len2--;
        	
        }if(carry==1)res.append(1);
        return new StringBuilder(res.reverse().toString()).toString();
        }
    
    public static void main(String[] args) {
		System.out.println(addStrings("11", "123"));
	}
}
