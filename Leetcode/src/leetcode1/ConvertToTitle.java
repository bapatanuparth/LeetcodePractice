package leetcode1;

//Given an integer columnNumber,
//return its corresponding column title as it appears in an Excel sheet.
//
//Z -> 26
//AA -> 27
//AB -> 28 
public class ConvertToTitle {
	
	//given 28 -->"AB"
	  public static String convertToTitle(int n) {
	        StringBuffer result = new StringBuffer();
	        char ch;
	        while (n > 0) {
	            ch = (char)((int)'A' + (n-1) % 26);
	            n = (n-1)/26;
	            result.append(ch);
	        }
	        return new String(result.reverse());
	    }
	
	//given title "AB" return -->28
	 public int titleToNumber(String str) {
	        int num=str.charAt(str.length()-1)-'A'+1;
	        System.out.println(num);
	        int i;
	        int n=1;
	        for(i=str.length()-2;i>=0;i--){
	            int temp=(int)Math.pow(26,n)*(str.charAt(i)-'A'+1);
	            num+=temp;
	            n++;
	        }
	        return num;
	    }
	 
	 //more efficient way
	 public int titletoNumberEff(String columnTitle) {
		 int res = 0;
	        for(int i=0; i<columnTitle.length(); i++) {
	            res *= 26;
	            res += columnTitle.charAt(i)-'A'+1;
	        }
	        
	        return res;
	 }

	
	 public static void main(String[] args) {
		convertToTitle(52);
	}
}
