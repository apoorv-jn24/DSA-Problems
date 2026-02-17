import java.util.*;
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        int n=s.length();
        if(n<=1) return s;
        String ans="";
        for(int i=0; i<n; i++){
            String oddLen=expandStr(s,i,i);
            String evenLen = expandStr(s,i,i+1);
            String longer = oddLen.length() >evenLen.length() ? oddLen :evenLen;
            if(longer.length() > ans.length()) ans=longer;
        }
        return ans;

    }
    private static String expandStr(String s, int left, int right){
        while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
