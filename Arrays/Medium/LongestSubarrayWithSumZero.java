import java.util.HashMap;
public class LongestSubarrayWithSumZero {
    public static void main(String[] args) {
        
    }
    public static int maxLength(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0, maxLength=0;
        map.put(0, -1);
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum==0) maxLength=i+1;
            else if(map.containsKey(sum)){
                maxLength=Math.max(maxLength, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
