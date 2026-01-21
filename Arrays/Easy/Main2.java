import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        int [] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
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
    public static int[] twoSum(int[] nums, int target) {
        // Brute Force Approach
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // Optimal Approach using HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // return an invalid pair if no solution found
    }
    // Majority Element - LeetCode 169 [n/2]
    public static int majorityElement(int[] nums) {

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
}