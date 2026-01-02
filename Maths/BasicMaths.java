import java.util.*;
public class BasicMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a,b));
        System.out.println(reverse(a));
        System.out.println(isPalindrome(a));
        System.out.println(countDigits(a)); 
        sc.close();
    }
    // to reverse a number(leetcode variant)
    public static int reverse(int x) {
        int revN =0;
        while(x!=0){
            int digits = x%10;
            if(revN< Integer.MIN_VALUE/10 || revN>Integer.MAX_VALUE/10) return 0;
            revN= revN*10+ digits;
            x= x/10;
        }
        return revN;
    }
    // to check if a number is palindrome
    public static boolean isPalindrome(int n) {
        int digits;
        int x=n;
        if(x<0) return false;
        long revN =0;
        while(x!=0){
        digits = x%10;
        revN= revN*10+ digits;
        x= x/10;
        }
        if(revN==n) return true;
        return false;
    }
    // to count digits in a number
    public static int countDigits(int n) {
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        return count;
    }
    // to find gcd of two numbers
    public static int gcd(int a, int b) {
        // code here
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }
        if(a==0) return b;
        return a;
    }
}
