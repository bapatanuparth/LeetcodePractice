package leetcode1;


//Given two binary strings a and b, return their sum as a binary string.
//Input: a = "11", b = "1"
//Output: "100"

//ez solution is to convert binary to decimal -->add numbers --> convert decimal to binary
//can use functions
//problem with solution -- for very very very long string, even int and long cannot help
//have to use binary addition directly to give output
public class AddBinary {
	
	//Using inbuilt EZ functions -->
	//this gives issue for large input strings
    public static String addBinary(String a, String b) {
     int a1=Integer.parseInt(a, 2);
     int b1=Integer.parseInt(b, 2);
     int sum=a1+b1;
     return Integer.toBinaryString(sum);
    }
    
    public static String addBinary2(String a, String b) {
        int a1=a.length()-1;
        int b1=b.length()-1;
        StringBuilder res=new StringBuilder();
        int carry=0;
        while(a1>=0 || b1>=0) {
        	int sum=carry;
        	int n1=(a1>=0?a.charAt(a1)-'0':0);
        	int n2=(b1>=0?b.charAt(b1)-'0':0);
        	sum=n1+n2+carry;
        	carry=sum>1?1:0;
        	res.append(sum%2);
        	a1--;b1--;
        }
        if(carry!=0) {
        	res.append(carry);
        }
        return res.reverse().toString();
       }
    
    public static void main(String[] args) {
    	//these kind of inputs will give trouble
		addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
				,"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
	}

}
