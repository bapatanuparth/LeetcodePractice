package leetcodeStrings;

//Input: s1 = "xx", s2 = "yy"
//Output: 1
//Explanation: Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
//
//Input: s1 = "xy", s2 = "yx"
//Output: 2
//Explanation: Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
//Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
//
//Input: s1 = "xx", s2 = "xy"
//Output: -1

//string equal length, contains only x or y
public class MinSwapsToMakeStringEqual {

	 public int minimumSwap(String s1, String s2) {
	        //if(s1.length()!=s2.length())return -1;
	        int res=0;
	        int x1=0, x2=0, y1=0, y2=0;
	        for(int i=0;i<s1.length();i++){
	            if(s1.charAt(i)!=s2.charAt(i)){
	                if(s1.charAt(i)=='x'){
	                    x1++;
	                    y2++;
	                }else {
	                    y1++;
	                    x2++;
	                    }
	            }
	        }
	        if((x1+x2)%2!=0 || (y1+y2)%2!=0)return -1;
	        res+=Math.min(x1/2,y2/2);
	        x1=x1-2*(x1/2);
	        y2=y2-2*(y2/2);
	        res+=Math.min(x2/2,y1/2);
	        x2=x2-2*(x1/2);
	        y1=y1-2*(y2/2);
	        
	        if(x1==1 || y1==1)res+=2;
	        return res;
	}
}
