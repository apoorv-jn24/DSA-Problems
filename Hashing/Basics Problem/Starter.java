import java.util.*;
// some basics problems on hashing
public class Starter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        // Hash Set to store unique elements - Syntax
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     set.add(arr[i]);
        // }
        // System.out.println("Number of unique elements: "+ set.size());
        countFrequency(arr);
        sc.close();
    }
    // count frequency of elements in an array
    public static void countFrequency(int[] arr){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // to print frequency of each element
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }
}
