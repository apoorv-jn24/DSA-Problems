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
        // Aao all approach karte hain is problem ko.
        // Approach 1: Using HashMap
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num:nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(entry.getValue()==1) return entry.getKey();
        // }
        // return -1;
        // Approach 2: Using Sorting
        // Arrays.sort(nums);
        // every number is thrice
        // for(int i=0; i<nums.length-1; i+=3){
        //     if(nums[i]!=nums[i+1]) return nums[i];
        // }
        // return nums[nums.length-1];
        // Approach 3: Using Bit Manipulation
        // int answer=0;
        // for(int i=0; i<32; i++){
        //     int count=0;
        //     for(int num:nums){
        //         if((num & (1<<i)) !=0) count++;
        //     }
        //     if(count%3!=0) answer|=(1<<i);
        // }
        // return answer;
        // Optimal Approach: Using Bit Manipulation with O(1) space
        // this approach is difficult to think on i also take out help from ai and striever video
        // lets understand
        int ones=0, twos=0;
        // agar ek baar aya to ek baar warna two mai bhej denge agar teesri baar aaya to dono se nikal denge
        for(int num:nums){
            ones=(ones^num) & (~twos);
            twos=(twos^num) & (~ones);
            // Number ko 1 mai laane ke liye kya karna hai ki one ka xor mtlb add aur wo number two mai nahi hona chaiye to uska complement and vice versa
            // we can dry run this is the game of bits
        }
        return ones;
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
    // Reverse Bits - Leetcode 190
    public int reverseBits(int n) {
        int res=0;
        for(int i=0; i<32; i++){
           res<<=1;
           res |= (n&1);
           n>>>=1;
        }
        // dry run karke dekh lena samaj jaoge curiosity bhi 
        // loop do baar nahi chalana padega
        return res;
    }
    // Sinbgle Number-3 
    public int[] singleNumber3(int[] nums) {
        int xor=0;
        int[] ans=new int[2];
        for(int num:nums){
            xor^=num;
        }
        // ab matter hai ki dono number ko alag kaise kare so for that we use bits
        // called as bucket sort approach 
        int rightMostBit= (xor & (xor-1)) ^ xor;
        // yaha se rightmost bit aai jo dono number me alag hai (sabse pehli bit jo alag hai from right)
        // ab dono ko alag group mai baat do and kyuki saare element 2 baar hai toh wo sab cancel out ho jayenge
        int num1=0, num2=0;
        for(int num:nums){
            if((num & rightMostBit) !=0) num1^=num;
            else num2^=num;
        }
        ans[0]=num1; ans[1]=num2;
        return ans;
    }

}
