import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
    }
    // binary search general code
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    // First And last occurence of element in sorted array
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        int idx=-1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                idx=mid;
                high=mid-1; 
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        arr[0]=idx;
        low = 0; high = nums.length - 1; idx=-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                idx=mid;
                low=mid+1; 
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        arr[1]=idx;
        return arr;
    }
    public  static int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
