import java.util.*;
public class palindromeNumber {
    public static void main(String[] args) {
        int n=121;
        System.out.println(isPalindrome(n));
    }
    // Leetcode- 9
    public static boolean isPalindrome(int n) {
        if(n<0) return false;
        int reverseNumber=0;
        int originalNumber = n;
        while(n>0){
            int digit=n%10;
            reverseNumber = reverseNumber * 10 + digit;
            n=n/10;
        }
        if(reverseNumber==originalNumber){
            return true;
        }
        return false;
    }
}
