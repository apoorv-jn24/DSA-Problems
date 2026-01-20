// Leetcode Problem 1: Two Sum
import java.util.HashMap;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        // Approach one 
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return null; // Return null if no solution is found
        // Approach two
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if(map.containsKey(pair)) {
                return new int[]{map.get(pair), i};
            }
            map.put(nums[i], i);
    }
        return null; // Return null if no solution is found
    }
}
