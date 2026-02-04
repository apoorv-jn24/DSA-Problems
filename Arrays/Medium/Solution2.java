import java.util.*;
public class Solution2 {
    public static void main(String[] args) {
       
    }
    // rotate image - leetcode 48
    public void rotate(int[][] matrix) {
         int n= matrix.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0; i<n; i++){
            int left=0, right=n-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
    }
    }
    // subarray sum equals k - leetcode 560
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    // Longest Consecutive Sequence - LeetCode 128
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int result=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int current=num;
                int count=1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
            result = Math.max(result, count);
            }
        }
        return result;
    }
    // Maximum Product Subarray - LeetCode 152
    public static int maxProduct(int[] nums) {
       
    }
    // Sort an array of 0s, 1s and 2s (Sort Colours- LeetCode 75)
    public void sortColors(int[] nums) {
        int low=0, mid=0, high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++; mid++;
            }else if(nums[mid]==1){
                mid++;
            } else{
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
    
    
}
