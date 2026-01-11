import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        int[] arr = {0,1,0,3,12};
        int k = scanner.nextInt();
        rotate(arr, k);
        int[] arr2 = {4,1,2,1,2};
        System.out.println(findUnion(arr, arr2));
        scanner.close();
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
}
