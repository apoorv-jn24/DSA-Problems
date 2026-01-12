import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(removeDuplicates(arr));
        System.out.println(check(arr));
        int[] arr1 = {2, 2, 3, 4, 5};
        int[] arr2 ={1, 1, 2, 3, 4};

    }
    // maximum element of the array
    public static int maximumElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    // missing number in array
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int totalSum=n*(n+1)/2;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return totalSum - sum;
    }
    // second maximum element of the array
    public static int secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max){
                secondMax = max;
                max = num;
            } else if(num > secondMax && num != max){
                secondMax = num;
            }
        }       
        return secondMax;
    }
    // LeetCode Problem 26: Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left=0, right=1;
        while(right < nums.length){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
    // check if the array is sorted and rotated
    public static boolean check(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                count++;
            }
            if(count > 1) return false;
        }
        return true;
    }
    // move zeroes to the end of the array
     public static void moveZeroes(int[] nums) {
        int i = 0;
        int j=0;
        while(j<nums.length){
        if(nums[j]!=0){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
        }
    }
        for(int num:nums){
            System.out.print(num+" ");
        }
    }
    // single number
    public static int singleNumber(int[] nums) {
        int answer=0;
        for(int num:nums){
            answer^=num;
        }
        return answer;
    }
    // residue prefixes Leetcode 3803
     public static int residuePrefixes(String s) {
        Set<Character> f = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            f.add(s.charAt(i));
            if(f.size() == (i + 1) % 3) ans++;
        }
        return ans;
    }
   //
}
