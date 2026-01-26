import java.util.*;
public class NextPermutation {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(Arrays.toString(nextPermutation(nums)));
        
    }
    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot=-1; 
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                pivot=i; 
                break;
            }
        }
        if(pivot==-1){
            reverse(nums, 0, n-1);
            return nums;
        }
        for(int i=n-1; i>pivot; i--){
            if(nums[i]>nums[pivot]){
                int temp = nums[i];
                nums[i]=nums[pivot];
                nums[pivot]=temp;
                break;
            }
        }
        reverse(nums, pivot+1, n-1);
        return nums;
    }
    private  static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
