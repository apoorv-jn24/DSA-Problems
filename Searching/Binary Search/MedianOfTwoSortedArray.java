import java.util.*;
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public  static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*  Approach 1 - Merge and sort
        int[] arr = new int[nums1.length + nums2.length];
        int n=nums1.length, m=nums2.length;
        int i=0, j=0, k=0;
        while(i<n && j<m){
            // check which is small and insert accordingly
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            } else {
                arr[k++]=nums2[j++];
            }
        }
        while(i<n){
            arr[k++]=nums1[i++];
        }
        while(j<m){
            arr[k++]=nums2[j++];
        }
        int mid = arr.length/2;
        if(arr.length%2==0){
            return (arr[mid]+arr[mid-1])/2.0;
        } 
        return arr[mid];
        */
        /* Approach 2 - Optimal Approach using Binary Search
         Dekho binary search ka mainly yaha kaam hai kya we want 
         to find out the search space ki kitne element konse array se 
         pick up karne hai like pehle se ek array aayega ya dusre se kitne element 
         pick kiye jayenge bas hume elements mil jayenge to usi se me3dian nikalna 
         aasan rahega */
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array taki ek array 
            // par hi operation karte rahe hum
        }
        int low = 0, high = n1;
        // left mai kitne element aayenge total length ka aadha
        int left = (n1 + n2 + 1 )/ 2;
        while(low<=high){
            int mid1 = low + (high - low) / 2; // mid1 is the number of elements we are picking from nums1
            int mid2 = left - mid1; // mid2 is the number of elements we pick from nums2
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==1){
                    // this is odd
                    return Math.max(l1,l2);
                } else {
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0; // because of double type return by 2.0
                    
                }
            } else if(l1>r2){
                high=mid1-1; // agar l1 hi bada hai mtlb isse chote element dusri side hai
            } else {
                low=mid1+1;
            }
        }
        return 0.2551; // dummy value
    }
    // Kth element of two sorted arrays- similar idea of the above question

    public static int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        // ensure a is the smaller array
        if (n1 > n2) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = low + (high - low) / 2; 
            int mid2 = k - mid1;         
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2); // ⭐ k-th element
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
}
