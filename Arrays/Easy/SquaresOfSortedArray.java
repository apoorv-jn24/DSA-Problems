import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-9,-7,-5,-3};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int n=nums.length;
        // Approach one: Using Extra Space
    //     for(int i=0; i<n; i++){
    //         if(nums[i]<0) nums[i]=-nums[i];
    //     }
    //     Arrays.sort(nums);
    //     for(int i=0; i<n; i++){
    //         nums[i]=(nums[i]*nums[i]);
    //     }
    //     return nums;
    // }
    // Approach two: Two Pointers(Optimal)
        int[] result= new int[n];
        int left=0, right=n-1;
        int index=n-1;
        while(left<=right){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];
            if(leftSquare>rightSquare){
                result[index]=leftSquare;
                left++;
            }
            else{
                result[index]=rightSquare;
                right--;
            }
            index--;
        }
        return result;

    }
}
