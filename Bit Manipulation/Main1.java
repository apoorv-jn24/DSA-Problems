import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
    }
    // single number in an array- Leetcode 136
    public static int singleNumber1(int[] nums) {
        int answer=0;
        for(int num:nums){
            answer^=num;
        }
        return answer;
    }
    public int singleNumber2(int[] nums) {
        
    }
    // Minimum Bit Flips to Convert Number
     public static int minBitFlips(int start, int goal) {
        int ans= (start^goal);
        int count=0;
        for(int i=0; i<31; i++){
            if((ans & (1<<i)) !=0) count++;
        }
        return count;
    }
    // find XOR of numbers in a range - GFG
    public static int findXOR(int l, int r) {
       return xorUptoN(r) ^ xorUptoN(l - 1);
       // using the pattern for the xor properties. 
    // there is a fixed pattern for the xor in terms of 4 if we see that
    }
    static int xorUptoN(int n) {
        if (n % 4 == 0) return n;
        else if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else return 0;
    }
    // 
}
