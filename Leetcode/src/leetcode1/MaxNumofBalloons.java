package leetcode1;

//Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
public class MaxNumofBalloons {
    public int maxNumberOfBalloons(String text) {
        int a=0,b=0,l=0,o=0,n=0;
        int count=0;
        for(int i=0;i<text.length();i++){
                if(text.charAt(i)=='a')a++;
            else if(text.charAt(i)=='b')b++;
            else if(text.charAt(i)=='l')l++;
            else if(text.charAt(i)=='o')o++;
            else if(text.charAt(i)=='n')n++;
        }
        while(a>=1 || b>=1 || n>=1){
            if(a>=1 && b >=1 && n>=1 && l>=2 && o>=2)
            {
                count++;
                a--;b--;n--;l=l-2;o=o-2;
            }
            else break;
        }
        return count;
        
    }
}
