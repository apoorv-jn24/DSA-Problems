import java.util.*;
// some basics problems on hashing
public class Starter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]= sc.nextInt();
        // }
        // Hash Set to store unique elements - Syntax
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     set.add(arr[i]);
        // }
        // System.out.println("Number of unique elements: "+ set.size());
        // countFrequency(arr);
        String str = sc.nextLine();
        // System.out.println("First unique character index: " + firstUniqChar(str));
        String str2 = sc.nextLine();
        System.out.println("Are the two strings anagrams? " + isAnagram(str, str2));

        sc.close();
    }
    // count frequency of elements in an array
    public static void countFrequency(int[] arr){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // to print frequency of each element
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }
    // first unique character in a string
     public static int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    // valid anagram
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            freqMap.put(ch1, freqMap.getOrDefault(ch1, 0) + 1);
            freqMap.put(ch2, freqMap.getOrDefault(ch2, 0) - 1);
        }
        for (int val : freqMap.values()) {
        if (val != 0) return false;
        }
        return true;
    }
}
