import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        System.out.println(sumSubstrings("6759"));
    }
    // sum of beauty of all substrings - leetcode 1781
    public static int beautySum(String s) {
        int sum=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                sum += (maxFreq - minFreq);
            }
        }
        return sum;
    }
    // Sum of all substrings of a number- GFG
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        int totalSum = 0;
        int prev = 0; 
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            int curr = prev * 10 + (i + 1) * digit;
            totalSum += curr;
            prev = curr;
        }

        return totalSum;
    }
    // String to integer - Leetcode 8 (Atoi) Overflow version
    public int myAtoi(String s) {
        
    }
}
