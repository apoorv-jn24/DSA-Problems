import java.util.*;

public class Main {
    public static void main(String[] args) {
        
    }
    // binary search general code
    public static int binarySearch(int[] nums, int target) {
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
    // square root of a number
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
    // find peak element
    public static int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
}
// search in rotated sorted array
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    // find minimum in rotated sorted array
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
    // single element in a sorted array- leetcode 540
    public static int singleNonDuplicate(int[] nums) {
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if( (mid==0 || nums[mid-1]!= nums[mid] )&& (mid==nums.length-1 || nums[mid]!= nums[mid+1])) 
             return nums[mid];
            else if(mid>0 && nums[mid-1]==nums[mid]){
                int length = mid-start-1;
                if(length%2==0) start=mid+1;
                else end=mid-2;
            }else{
                int length = end-mid-1;
                if(length%2==0) end=mid-1;
                else start=mid+2;
            }
        }
        return -1;
    }
    // Nth root of a number
    public static int nthRoot(int n, int m) {
        // code here
        // edge cases
        if(m==0 || m==1) return m;
        int low=1, high=m;
        while(low<=high){
            int mid= low + (high-low)/2;
            long val=1;
            for(int i=0; i<n; i++){
                val*=mid;
            }
            if(val==m) return mid;
            else if(val<m) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}
