package leetcode1;


//using string and array of where spaces should be inserted,
//Each space should be inserted before the character at the given index.
//return the modified string

//Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
//Output: "Leetcode Helps Me Learn"
public class AddSpaceToString {
	
	//this program is easy because it uses built in function,
	//but gives output liit exceeded issue woth large inputs
	  public String addSpaces(String s, int[] spaces) {
	        String ans=""+s.substring(0,spaces[0])+" ";
	        for(int i=0;i<spaces.length-1;i++){
	            ans=ans+s.substring(spaces[i], spaces[i+1])+" ";
	            
	            System.out.println(ans);
	        }
	        ans=ans+s.substring(spaces[spaces.length-1], s.length());
	        return ans;
	    }
	  
	  //approach 2 giving TLE if used directly string like ans=""; and ans+=" ";
	  //use stringbuilder that works faster
	    public String addSpaces2(String s, int[] spaces) {
	        StringBuilder sb = new StringBuilder();
	        int p = 0;
	        for(int i=0;i<s.length();i++) {
	            if(p < spaces.length && spaces[p]==i) {
	                sb.append(" ");
	                p++;
	            }
	            sb.append(s.charAt(i));
	        }
	        return sb.toString();
	    }


}
