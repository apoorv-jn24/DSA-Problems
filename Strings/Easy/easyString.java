import java.util.*;
public class easyString {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
        String num = "35427";
        System.out.println(largestOddNumber(num));
        String str1 = "abcde", str2 = "deabc";
        System.out.println(rotateString(str1, str2));
        String s1 = "egg", s2 = "add";
        System.out.println(isIsomorphic(s1, s2));
    }
     // longest common prefix - leetcode 14
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i=0; i<strs[0].length(); i++){
            char ch= strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(i>=strs[j].length() || ch!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    // Remove outermost parentheses - LeetCode 1021
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                if(count>0){
                    sb.append(ch);
                }
                count++;
            } else {
                count--;
                if(count>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
    // largest odd number in the string
    public static String largestOddNumber(String s) {
        for(int i=s.length()-1; i>=0; i--){
            if((s.charAt(i)-'0')%2==1) return s.substring(0,i+1);
        }
        return "";
    }
    // rotate string - leetcode 796
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String target= s+s;
        return target.contains(goal);
    }
    // isomorphic strings- leetcode 205
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] mapS = new char[256];
        char[] mapT = new char[256];
        for(int i=0; i<s.length(); i++){
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(mapS[chS] == 0 && mapT[chT] == 0){
                mapS[chS] = chT;
                mapT[chT] = chS;
            } else if(mapS[chS] != chT || mapT[chT] != chS){
                return false;
            }
        }
        return true;
    }
    // Roman to Integer - LeetCode 13
    public static int romanToInt(String s) {
        int ans=0;
        for(int i=0; i<s.length()-1; i++){
            char ch = s.charAt(i);
            if(valueOfChar(ch)<valueOfChar(s.charAt(i+1))){
                ans -= valueOfChar(ch);
            } else {
                ans += valueOfChar(ch);
            }
        }
        ans+=valueOfChar(s.charAt(s.length()-1));
        return ans;
    }
    private static int valueOfChar(char ch){
        if(ch=='I') return 1;
        else if(ch=='V') return 5;
        else if(ch=='X') return 10;
        else if(ch=='L') return 50;
        else if(ch=='C') return 100;
        else if(ch=='D') return 500;
        else if(ch=='M') return 1000;
        return 0;
    }
   
}
