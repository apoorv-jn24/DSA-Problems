import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // int k = scanner.nextInt();
        // rotate(arr, k);
        int[] arr2 = {4,1,2,1,2};
        // System.out.println(findUnion(arr, arr2));
        // System.out.println(numRescueBoats(arr2, 0));
        System.out.println(maxSubArray(arr));
        scanner.close();
    }
    // find the duplicate number
    public static int findDuplicate(int[] nums) {
    /*  Normal or Brute Force Approach
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
        */
    /*
    Another approach using HashSet
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
     */
    /*
    One More Approach by frequency array
    int n = nums.length;
    int[] freq = new int[n];
    for (int num : nums) {
        freq[num]++;
        if (freq[num] > 1) {
            return num;
        }
    }
    */
//    Optimal Approach: Floyd's Tortoise and Hare (Cycle Detection)
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow=nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    // rotate the array by k steps 
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    // reverse the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
     // union of two sorted arrays
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int i=0, j=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                if(!set.contains(a[i])){
                    result.add(a[i]);
                    set.add(a[i]);
                }
                i++;
            } else if(b[j]<a[i]){
                if(!set.contains(b[j])){
                    result.add(b[j]);
                    set.add(b[j]);
                }
                j++;
            } else {
                if(!set.contains(a[i])){
                    result.add(a[i]);
                    set.add(a[i]);
                }
                i++;
                j++;
            }
        }
        while(i<a.length){
            if(!set.contains(a[i])){
                result.add(a[i]);
                set.add(a[i]);
            }
            i++;
        }
        while(j<b.length){
            if(!set.contains(b[j])){
                result.add(b[j]);
                set.add(b[j]);
            }
            j++;
        }
        return result;
    }
    // boats to save people- leetcode 881   
    public  static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0, j=people.length-1;
        int boats=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
    // maximum  subarray leetcode-53 (Kadane's Algorithm)
    public static int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum = Integer.MIN_VALUE;;
        for(int num:nums){
            sum+=num;
            maxSum = Math.max(maxSum, sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
//  longest subarray with sum k geeks for geeks
    public static int longestSubarray(int[] arr, int k) {
        // code here
        // brute force approach O(n^2)
        // int maxLength=0;
        // for(int i=0; i<arr.length; i++){
        //     int sum=0;
        //     for(int j=i; j<arr.length; j++){
        //         sum += arr[j];
        //         if(sum == k){
        //             maxLength = Math.max(maxLength, j - i + 1);
        //         }
        //     }
        // }
        // return maxLength;
        
        // optiomal approach O(n)
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == k) {
                maxLength = i + 1;
            }
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
            if (prefixSumMap.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - k));
            }
        }
        return maxLength;
    }
    // Rearrange Array elements by alternate sign  - LeetCode 2149
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0; // Pointer for positive numbers
        int negIndex = 1; // Pointer for negative numbers
        for(int num:nums){
            if(num>=0){
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }
    // Longest Balanced Subarray-I - LeetCode 3719
    public static int longestBalanced(int[] nums) {
        int max=0;
        for(int i=0; i<nums.length; i++){
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2==0){
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                if(even.size() == odd.size()){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
