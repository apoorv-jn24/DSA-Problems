public class CountSubarrayWithGivenXorGFG {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subarrayXor(arr, k));
    }
    public static long subarrayXor(int arr[], int k) {
        // code here
        int xor=0;
        long count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            xor = xor ^ arr[i];
            if(xor == k) count++;
            int x = xor ^ k;
            if(map.containsKey(x)){
                count+= map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return count;
    }
}
