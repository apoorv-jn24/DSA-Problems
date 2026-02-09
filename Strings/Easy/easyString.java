import java.util.*;
public class easyString {
    public static void main(String[] args) {
        
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
    public boolean rotateString(String s, String goal) {
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
   
}
