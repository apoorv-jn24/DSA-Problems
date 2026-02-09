import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        int [] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    
    // max consecutive onesw in an array- leetcode 485
    public static int findMaxConsecutiveOnes(int[] nums) {
       int count=0, maxCount=0;
       for(int num:nums){
        if(num==1) count++;
        else count=0;
        maxCount = Math.max(maxCount, count);
       }
       return maxCount;
    }
    // Two Sum Problem -LeetCode 1
    // public static int[] twoSum(int[] nums, int target) {
    //     // Brute Force Approach
    //     // for(int i=0; i<nums.length; i++){
    //     //     for(int j=i+1; j<nums.length; j++){
    //     //         if(nums[i] + nums[j] == target){
    //     //             return new int[]{i, j};
    //     //         }
    //     //     }
    //     // }
    //     // Optimal Approach using HashMap
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int i=0; i<nums.length; i++){
    //         int complement = target - nums[i];
    //         if(map.containsKey(complement)){
    //             return new int[]{map.get(complement), i};
    //         }
    //         map.put(nums[i], i);
    //     }
    //     return new int[]{-1, -1}; // return an invalid pair if no solution found
    // }
    // Majority Element - LeetCode 169 [n/2]
    public static int majorityElement(int[] nums) {
        int freq=0, ans=0;
        for(int num:nums){
            if(freq==0) ans=num;
            if(num==ans) freq++;
            else freq--;
        }
        return ans;

    }
    // buy and sell stock - leetcode 121
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price:prices){
            if(price<minPrice){
                minPrice = price;
            } else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
    // Merge two Sorted Arrays - LeetCode 88
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            } else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }
    // Maximum difference between Highest and lowest of K- Score LeetCode 1984
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length, i=0;
        while(i+k-1<n){
            minDiff = Math.min(minDiff, nums[i+k-1]-nums[i]);
            i++;
        }
        return minDiff;
    }
    // Pascal Triagle- LeetCode 118
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    row.add(1);
                } else{
                    row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(row);
        }
        return list;
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
}