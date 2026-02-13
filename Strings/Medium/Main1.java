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
        s=s.trim();
        if(s.length()==0) return 0;
        int sign=1; // 1 for positive, -1 for negative (after multiplication)
        int i=0, n=s.length(), ans=0;
        if(s.charAt(0)=='-'){
            sign*=-1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            // Check for overflow
            if(ans> Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && digit>7)){
                //sign works for negative element digit isilie liya because integer max aur min ki last digit 7 hai
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans=ans*10+digit;
            i++;
        }
        return ans*sign;
    }
    // longest palindromic substring - Leetcode 5
    public static String longestPalindrome(String s) {
        // Brute force approach - O(n^3)
    //     int n=s.length();
    //     String longest=""; // empty string palindrome consider hoti hai 
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             if(isPalindrome(s,i,j)){
    //                 String curr=s.substring(i,j+1);
    //                 if(curr.length()>longest.length()){
    //                     longest=curr;
    //                 }
    //             }
    //         }
    //     }
    //     return longest;
    // }
    // private static boolean isPalindrome(String s, int left, int right){
    //     while(left<right){
    //         if(s.charAt(left)!=s.charAt(right)){
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // Optimal Approach
    
    }
    // 451. Sort Characters By Frequency
    public static String frequencySort(String s) {
        //sabse pehle frequency count
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // sort using collections but uske liye list mai daalna padega kyuki map ko directly sort nahi kar sakte
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());// map-list mai convert
        //ab list ko sort kaise kare- using collections- but decreasing order mai bhi karna hai
        // uske liye freq(b,a) wala method banana padega lets try
        Collections.sort(list, (a,b) -> b.getValue() - a.getValue());
        // upar wala ek lamda expression hai bhai 
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer> entry : list){
            char ch=entry.getKey();
            int freq=entry.getValue();
            for(int i=0; i<freq; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    // Integer to Roman - Leetcode 12
     public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i=0; i<values.length; i++){
            while(num >= values[i]){
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
